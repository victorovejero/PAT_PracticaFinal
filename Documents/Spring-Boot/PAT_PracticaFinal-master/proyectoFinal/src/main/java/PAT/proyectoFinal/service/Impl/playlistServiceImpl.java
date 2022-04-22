package PAT.proyectoFinal.service.Impl;

import PAT.proyectoFinal.model.cancionModel;
import PAT.proyectoFinal.model.playlistModel;
import PAT.proyectoFinal.repository.cancionRepository;
import PAT.proyectoFinal.repository.playlistRepository;
import PAT.proyectoFinal.service.playlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import PAT.proyectoFinal.repository.playlistRepository;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.List;

@Service
public class playlistServiceImpl implements playlistService {
  AtomicInteger id = new AtomicInteger();

  @Autowired
  playlistRepository playlistRepository;


  @Override
  public Iterable<playlistModel> getPlaylistsService(){
    return playlistRepository.findAll();
  }

  @Override
  public Iterable<playlistModel> getPlaylistByIdService(String id, String user){

    return playlistRepository.findPlaylistById(id, user);
  }

  @Override
  public Iterable<playlistModel> getPlaylistByUserService(String user){

    return playlistRepository.findPlaylistByUser(user);
  }

  @Override
  public Iterable<playlistModel> getPlaylistService(){
    return playlistRepository.findAll();

  }

  @Override
  public void deletePlaylistByNameService(String name, String user){
    playlistRepository.deletePlaylistByNameAndUser(name, user);
  }

  @Override
  public void createPlaylistByIdService(String name, String user){
    int id1 = id.getAndIncrement();
    playlistRepository.createPlaylistById(id1, name, user);
  }

  @Override
  public boolean checkIfPlaylistExistsService(String id, String user){
    String exists = playlistRepository.trueOrFalsePlaylistService(id,user);
    if(exists == "TRUE"){
      return true;
    }else{
      return false;
    }
  }




}
