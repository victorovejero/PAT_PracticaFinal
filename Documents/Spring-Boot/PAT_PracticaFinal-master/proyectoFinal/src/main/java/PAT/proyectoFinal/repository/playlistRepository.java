package PAT.proyectoFinal.repository;


import PAT.proyectoFinal.model.playlistModel;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface playlistRepository extends CrudRepository<playlistModel,Integer> {

    AtomicInteger id = new AtomicInteger();




  @Query("SELECT * FROM PLAYLIST WHERE NOMBRE=:nombre AND USER=:user")
  Iterable<playlistModel> findPlaylistById(@Param("nombre") String nombre, @Param("user") String user);

  @Query("SELECT * FROM PLAYLIST WHERE USER=:user")
  Iterable<playlistModel> findPlaylistByUser(@Param("user") String user);

  @Modifying
  @Query("INSERT INTO PLAYLIST (ID, NOMBRE, USER) VALUES (:id, :nombre, :user)")
  void createPlaylistById(int id, @Param("nombre") String nombre, @Param("user") String user);

  @Query("SELECT CASE WHEN EXISTS (SELECT * FROM PLAYLIST WHERE NOMBRE=:nombre AND USER=:user) THEN TRUE ELSE FALSE END AS bool")
  String trueOrFalsePlaylistService(@Param("nombre") String nombre, @Param("user") String user);

  @Modifying
  @Query("DELETE * FROM PLAYLIST WHERE NAME=:nombre AND USER=:user")
    void deletePlaylistByNameAndUser(@Param("nombre") String nombre, @Param("user") String user);
}



//DUDAS
//1. Como puedo hacer queries que cojan un input por el metodo que se lo pueda pasar mediante un HTTP request

