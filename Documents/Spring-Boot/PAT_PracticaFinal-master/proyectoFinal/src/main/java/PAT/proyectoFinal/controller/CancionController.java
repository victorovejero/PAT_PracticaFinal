package PAT.proyectoFinal.controller;

import PAT.proyectoFinal.model.cancionModel;
import PAT.proyectoFinal.model.playlistModel;
import PAT.proyectoFinal.service.cancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import PAT.proyectoFinal.service.cancionService;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class CancionController {

  @Autowired
  cancionService cancionService;


  @GetMapping("/canciones")
  public ResponseEntity<Iterable<cancionModel>> getCanciones(){
    return ResponseEntity.ok().body(cancionService.getCancionesService());
  }

  @GetMapping("/cancion/{id}")
  public ResponseEntity<Iterable<cancionModel>> getCancionById(@PathVariable String id){


    //return ResponseEntity.ok().body(id);

    return ResponseEntity.ok().body(cancionService.getCancionByIdService(id));
  }

  @GetMapping("/cancion/delete/{name}")
  public ResponseEntity<Void> deleteCancionById(
          @PathVariable String name,
          @RequestParam(value="playlist",required=true) String playlist
          ){


    cancionService.deleteCancionByNameAndPlaylistService(name, playlist);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/cancion/create")
  public ResponseEntity<String> createCancionById(
          @RequestBody cancionModel cancion,
          BindingResult bindingResult){

    if(bindingResult.hasErrors()){
      return new ResponseEntity<String>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
    }else{
      cancionService.createCancionService(cancion);
      return new ResponseEntity<String>("{\"result\" : \"OK\"}", HttpStatus.OK);
    }

  }


  @GetMapping("/canciones/playlist/{id}")
  public ResponseEntity<Iterable<cancionModel>> getCancionesByPlaylist(
          @PathVariable String id){

    return ResponseEntity.ok().body(cancionService.getCancionesByPlaylistService(id));
  }

}
