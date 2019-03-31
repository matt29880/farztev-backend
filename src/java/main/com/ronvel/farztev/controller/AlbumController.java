package com.ronvel.farztev.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ronvel.farztev.controller.dto.Album;
import com.ronvel.farztev.controller.dto.ListAlbum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-18T21:25:55.781+01:00")

@Api(value = "api", description = "the API")
public interface AlbumController {

  @ApiOperation(value = "", notes = "", response = Album.class, tags={  })
  @ApiResponses(value = { 
      @ApiResponse(code = 200, message = "successful operation", response = Album.class),
      @ApiResponse(code = 404, message = "Country not found", response = Album.class) })
  @RequestMapping(value = "/api/album/{albumId}",
      produces = { "application/json" }, 
      method = RequestMethod.GET)
  ResponseEntity<Album> apiAlbumAlbumIdGet(@ApiParam(value = "Album ID",required=true ) @PathVariable("albumId") Long albumId);

  @ApiOperation(value = "", notes = "", response = ListAlbum.class, responseContainer = "List", tags={  })
  @ApiResponses(value = { 
      @ApiResponse(code = 200, message = "successful operation", response = ListAlbum.class) })
  @RequestMapping(value = "/api/album",
      produces = { "application/json" }, 
      method = RequestMethod.GET)
  ResponseEntity<List<ListAlbum>> apiAlbumGet();

}
