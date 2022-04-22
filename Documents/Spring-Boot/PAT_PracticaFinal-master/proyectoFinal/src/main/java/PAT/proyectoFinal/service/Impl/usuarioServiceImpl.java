package PAT.proyectoFinal.service.Impl;

import PAT.proyectoFinal.model.usuarioModel;
import PAT.proyectoFinal.repository.usuarioRepository;
import PAT.proyectoFinal.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usuarioServiceImpl implements usuarioService {

  @Autowired
  private usuarioRepository usuarioRepository;


  @Override
  public Iterable<usuarioModel> getUsuariosService(){
    return usuarioRepository.findAll();
  }

  @Override
  public Iterable<usuarioModel> getUsuarioByIdService(String id){

    return usuarioRepository.getUsuarioById(id);
  }

  @Override
  public void deleteUsuarioByIdService(String id){
    usuarioRepository.deleteById(id);
  }

  @Override
  public String compararYCrearUsuarioService(usuarioModel usuario){

    String username = usuario.getUsername();
    boolean usuarioExists = usuarioRepository.existsById(username);
    if(usuarioExists){
      return "User Already Exists.";
    }else{
      String nombre = usuario.getNombre();
      String apellido = usuario.getApellido();
      String email = usuario.getEmail();
      int edad = usuario.getEdad();
      String password = usuario.getPassword();
      usuarioRepository.crearUsuario(username,nombre,apellido,email,edad,password);
      return "OK";
    }

  }


}
