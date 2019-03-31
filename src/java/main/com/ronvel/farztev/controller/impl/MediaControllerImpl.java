package com.ronvel.farztev.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import com.ronvel.farztev.controller.MediaController;
import com.ronvel.farztev.controller.dto.ListMedia;
import com.ronvel.farztev.controller.dto.Media;
import com.ronvel.farztev.service.MediaService;
import io.swagger.annotations.ApiParam;

@Controller
public class MediaControllerImpl implements MediaController {

  @Autowired
  MediaService mediaService;

  public ResponseEntity<List<ListMedia>> apiAlbumAlbumIdMediaGet(
      @ApiParam(value = "Album ID", required = true) @PathVariable("albumId") Long albumId) {
    List<ListMedia> medias = mediaService.listMedias();
    return new ResponseEntity<List<ListMedia>>(medias, HttpStatus.OK);
  }

  public ResponseEntity<Media> apiAlbumAlbumIdMediaMediaIdGet(
      @ApiParam(value = "Album ID", required = true) @PathVariable("albumId") Long albumId,
      @ApiParam(value = "Media ID", required = true) @PathVariable("mediaId") Long mediaId) {
    Optional<Media> mediaOptional = mediaService.findMediaById(mediaId);
    return mediaOptional.map(media -> new ResponseEntity<Media>(media, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<Media>(HttpStatus.NOT_FOUND));
  }
}
