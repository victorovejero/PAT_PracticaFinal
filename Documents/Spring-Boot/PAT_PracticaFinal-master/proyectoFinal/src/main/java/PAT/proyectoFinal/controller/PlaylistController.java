package PAT.proyectoFinal.controller;

import PAT.proyectoFinal.exception.PlaylistAlreadyExistsSignUpException;
import PAT.proyectoFinal.model.cancionModel;
import PAT.proyectoFinal.model.playlistModel;
import PAT.proyectoFinal.service.cancionService;
import PAT.proyectoFinal.service.playlistService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class PlaylistController {

  @Autowired
  playlistService playlistService;

  @GetMapping("/playlists")
  public ResponseEntity<Iterable<playlistModel>> getPlaylists(){

    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("Result", "OK");
    System.out.println(responseHeaders);
    return new ResponseEntity<Iterable<playlistModel>>(playlistService.getPlaylistsService(),responseHeaders, HttpStatus.OK);

    //return ResponseEntity.ok().body(playlistService.getPlaylistsService());
  }


  @GetMapping("/playlists/{user}")
  public ResponseEntity<Iterable<playlistModel>> getPlaylistsByUser(
          @PathVariable String user
  ){

    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("Result", "OK");
    System.out.println(responseHeaders);
    return new ResponseEntity<Iterable<playlistModel>>(playlistService.getPlaylistByUserService(user),responseHeaders, HttpStatus.OK);

    //return ResponseEntity.ok().body(playlistService.getPlaylistsService());
  }

  //LOS TRES DE ARRIBA FUNCIONAN BIEN.

  //NO ESTA TERMINADO
  @RequestMapping(value="/playlist/{id}", method = RequestMethod.GET)
  public ResponseEntity<Iterable<playlistModel>> getPlaylistByName(
          @PathVariable String id,
          @RequestParam(value="user", required=true) String user){


    //return ResponseEntity.ok().body(id);

    return ResponseEntity.ok().body(playlistService.getPlaylistByIdService(id, user));
  }

  @GetMapping("/playlist/delete/{id}")
  public ResponseEntity<Void> deletePlaylist(
          @PathVariable String id,
          @RequestParam(value="user", required=true) String user
  ){
    playlistService.deletePlaylistByNameService(id,user);

    return ResponseEntity.ok().build();
  }


  @RequestMapping(value="/playlist/create/{id}", method = RequestMethod.GET)
  public ResponseEntity<String> createPlaylist(
          @PathVariable String id,
          @RequestParam(value="user", required=true) String user) {
    boolean checkAlreadyExists = playlistService.checkIfPlaylistExistsService(id,user);
    if(checkAlreadyExists){
      throw new PlaylistAlreadyExistsSignUpException();
    }else{
      playlistService.createPlaylistByIdService(id,user);
      return new ResponseEntity<>("{\"result\" : \"OK\"}", HttpStatus.OK);
    }


  }




}
