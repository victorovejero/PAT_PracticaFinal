package PAT.proyectoFinal.repository;

import PAT.proyectoFinal.model.cancionModel;
import PAT.proyectoFinal.model.playlistModel;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface cancionRepository extends CrudRepository<cancionModel,Integer> {

  AtomicInteger id = new AtomicInteger();



  @Query("SELECT * FROM CANCION WHERE ID=:id")
  Iterable<cancionModel> getCancionById(String id);

  //AL CREAR UNA CANCION, TAMBIEN TENGO QUE DIFERENCIAR ENTRE EL USUARIO QUE HA CREADO LA CANCION.
  @Modifying //SIEMPRE PONERLO CUANDO SE MODIFICA LA BASE DE DATOS
  @Query("INSERT INTO CANCION (id,nombre,playlist,artista,album,longitud) VALUES (:id,:nombre,:playlist,:artista,:album,:longitud)")
  void createCancion(int id, String nombre, String playlist, String artista, String album, int longitud);

  @Query("SELECT * FROM CANCION WHERE PLAYLIST=:playlist")
  Iterable<cancionModel> getCancionByPlaylist(String playlist);

  @Modifying
  @Query("DELETE * FROM CANCION WHERE NAME=:nombre AND PLAYLIST=:playlist")
  void deleteCancionByNameAndPlaylist(@Param("nombre") String nombre, @Param("playlist") String playlist);
}
