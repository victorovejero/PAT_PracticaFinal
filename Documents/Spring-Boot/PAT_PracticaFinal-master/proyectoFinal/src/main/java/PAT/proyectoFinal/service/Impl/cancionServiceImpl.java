package PAT.proyectoFinal.service.Impl;

import PAT.proyectoFinal.model.cancionModel;
import PAT.proyectoFinal.repository.cancionRepository;
import PAT.proyectoFinal.service.cancionService;
import org.springframework.beans.factory.annotation.Autowired;
import PAT.proyectoFinal.repository.cancionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class cancionServiceImpl implements cancionService {

  AtomicInteger id = new AtomicInteger();
  @Autowired
  private cancionRepository cancionRepository;

  @Override
  public Iterable<cancionModel> getCancionesService(){
    return cancionRepository.findAll();
  }

  @Override
  public Iterable<cancionModel> getCancionByIdService(String id){
    return cancionRepository.getCancionById(id);
  }

  @Override
  public void deleteCancionByNameAndPlaylistService(String name, String playlist){
    cancionRepository.deleteCancionByNameAndPlaylist(name, playlist);
  }

  @Override
  public void createCancionService(cancionModel cancion){
    int id1 = id.getAndIncrement();
    String nombre = cancion.getNombre();
    String playlist = cancion.getPlaylist();
    String artista = cancion.getArtista();
    String album = cancion.getAlbum();
    int longitud = cancion.getLongitud();
    cancionRepository.createCancion(id1,nombre,playlist,artista,album,longitud);
  }

  @Override
  public Iterable<cancionModel> getCancionesByPlaylistService(String playlist){

    return cancionRepository.getCancionByPlaylist(playlist);
  }
}
