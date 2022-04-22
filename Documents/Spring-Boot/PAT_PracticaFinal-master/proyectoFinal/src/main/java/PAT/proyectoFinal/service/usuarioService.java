package PAT.proyectoFinal.service;

import PAT.proyectoFinal.model.usuarioModel;

import java.util.List;

public interface usuarioService {

  Iterable<usuarioModel> getUsuariosService();
  Iterable<usuarioModel> getUsuarioByIdService(String id);
  void deleteUsuarioByIdService(String id);
  String compararYCrearUsuarioService(usuarioModel usuario);
}
