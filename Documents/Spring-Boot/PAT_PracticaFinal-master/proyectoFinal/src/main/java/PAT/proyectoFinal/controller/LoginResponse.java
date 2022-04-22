package PAT.proyectoFinal.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponse {
  private String result;
  private String accessToken;

  public LoginResponse(String ko) {
    this.result = ko;
  }
}
