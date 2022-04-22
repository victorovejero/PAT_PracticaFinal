package PAT.proyectoFinal.service.Impl;

import PAT.proyectoFinal.model.usuarioModel;
import PAT.proyectoFinal.service.LoginService;
import PAT.proyectoFinal.repository.usuarioRepository;
import PAT.proyectoFinal.service.LoginServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  private usuarioRepository usuarioRepository;

  @Override
  public LoginServiceResult LogInUsuarioService(usuarioModel usuario){

    String username = usuario.getUsername();
    String obtainedPassword = usuario.getPassword();
    String password;
    boolean usuarioExists = usuarioRepository.existsById(username);

    if(usuarioExists){
      password =  usuarioRepository.getPasswordFromUsername(username);
      if(password.equals(obtainedPassword)){
        String value = usuario.getUsername() + ":" + usuario.getPassword();
        String accessToken = Base64.getEncoder().encodeToString(value.getBytes());
        return new LoginServiceResult(true, accessToken);

      }else{
        return new LoginServiceResult(false, "Wrong Password");
      }
    }else{
      return new LoginServiceResult(false, "Not Found");
    }
  }
}
