package com.ronvel.farztev.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import com.ronvel.farztev.controller.AlbumController;
import com.ronvel.farztev.controller.dto.Album;
import com.ronvel.farztev.controller.dto.ListAlbum;
import com.ronvel.farztev.service.AlbumService;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2017-09-07T23:10:06.754+02:00")

@Controller
public class AlbumControllerImpl implements AlbumController {

  @Autowired
  private AlbumService albumService;

  @Override
  public ResponseEntity<Album> apiAlbumAlbumIdGet(
      @ApiParam(value = "Album ID", required = true) @PathVariable("albumId") Long albumId) {
    ResponseEntity<Album> response;

    Optional<Album> optionalAlbum = albumService.findAlbumById(albumId);
    if (optionalAlbum.isPresent()) {
      response = new ResponseEntity<Album>(optionalAlbum.get(),HttpStatus.OK);
    } else {
      response = new ResponseEntity<Album>(HttpStatus.NOT_FOUND);
    }

    return response;
  }

  @Override
  public ResponseEntity<List<ListAlbum>> apiAlbumGet() {
    List<ListAlbum> listAlbums = albumService.listAlbums();
    return new ResponseEntity<List<ListAlbum>>(listAlbums,HttpStatus.OK);
  }
}
