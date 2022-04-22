package PAT.proyectoFinal.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginServiceResult {

  private boolean flag;
  private String accessToken;


  public LoginServiceResult(boolean flag){ this.flag = flag;}

  public boolean isFlag() {
    return flag;
  }

  public String getAccessToken() {
    return accessToken;
  }
}
