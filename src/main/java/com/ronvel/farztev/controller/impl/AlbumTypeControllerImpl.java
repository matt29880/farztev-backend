package com.ronvel.farztev.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.ronvel.farztev.controller.AlbumTypeController;
import com.ronvel.farztev.controller.dto.AlbumType;
import com.ronvel.farztev.controller.dto.ListAlbumType;
import com.ronvel.farztev.service.AlbumTypeService;

@Controller
public class AlbumTypeControllerImpl implements AlbumTypeController {

  @Autowired
  private AlbumTypeService albumTypeService;
  
  @Override
  public ResponseEntity<AlbumType> apiAlbumtypeAlbumTypeIdGet(@PathVariable("albumTypeId") Long albumTypeId) {
    ResponseEntity<AlbumType> response;

    Optional<AlbumType> optionalAlbumType = albumTypeService.findAlbumTypeById(albumTypeId);
    if (optionalAlbumType.isPresent()) {
      response = new ResponseEntity<AlbumType>(optionalAlbumType.get(),HttpStatus.OK);
    } else {
      response = new ResponseEntity<AlbumType>(HttpStatus.NOT_FOUND);
    }

    return response;
  }
  @Override
  public ResponseEntity<List<ListAlbumType>> apiAlbumtypeGet() {
    List<ListAlbumType> listAlbumTypes = albumTypeService.listAlbumTypes();
    return new ResponseEntity<List<ListAlbumType>>(listAlbumTypes,HttpStatus.OK);
  }

}
