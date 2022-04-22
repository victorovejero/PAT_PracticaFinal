package PAT.proyectoFinal.repository;


import PAT.proyectoFinal.model.usuarioModel;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface usuarioRepository extends CrudRepository<usuarioModel,String> {



  @Query("SELECT * FROM USUARIO WHERE USERNAME=:id")
  Iterable<usuarioModel> getUsuarioById(@Param("id") String id);

  @Modifying
  @Query("INSERT INTO USUARIO (username,nombre,apellido,email,edad,password) " +
          "VALUES (:username,:nombre,:apellido,:email,:edad,:password)")
  void crearUsuario(String username,
                    String nombre,
                    String apellido,
                    String email,
                    int edad,
                    String password);

  @Query("SELECT PASSWORD FROM USUARIO WHERE USERNAME=:id")
  String getPasswordFromUsername(@Param("id") String id);
}
