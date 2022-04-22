package PAT.proyectoFinal.service;

import PAT.proyectoFinal.model.cancionModel;
import PAT.proyectoFinal.model.playlistModel;

import java.util.List;

public interface playlistService {

  Iterable<playlistModel> getPlaylistsService();

  Iterable<playlistModel> getPlaylistByIdService(String id, String user);

  Iterable<playlistModel> getPlaylistByUserService(String user);

  Iterable<playlistModel> getPlaylistService();

  void deletePlaylistByNameService(String name, String user);

  void createPlaylistByIdService(String name, String user);

  boolean checkIfPlaylistExistsService(String id, String user);


}
