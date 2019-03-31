package com.ronvel.farztev.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ronvel.farztev.controller.dto.AlbumType;
import com.ronvel.farztev.controller.dto.ListAlbumType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-18T21:25:55.781+01:00")

@Api(value = "api", description = "the API")
public interface AlbumTypeController {

  @ApiOperation(value = "", notes = "", response = AlbumType.class, tags={  })
  @ApiResponses(value = { 
      @ApiResponse(code = 200, message = "successful operation", response = AlbumType.class),
      @ApiResponse(code = 404, message = "Country not found", response = AlbumType.class) })
  @RequestMapping(value = "/api/albumtype/{albumTypeId}",
      produces = { "application/json" }, 
      method = RequestMethod.GET)
  ResponseEntity<AlbumType> apiAlbumtypeAlbumTypeIdGet(@ApiParam(value = "Album Type ID",required=true ) @PathVariable("albumTypeId") Long albumTypeId);

  @ApiOperation(value = "", notes = "", response = ListAlbumType.class, responseContainer = "List", tags={  })
  @ApiResponses(value = { 
      @ApiResponse(code = 200, message = "successful operation", response = ListAlbumType.class) })
  @RequestMapping(value = "/api/albumtype",
      produces = { "application/json" }, 
      method = RequestMethod.GET)
  ResponseEntity<List<ListAlbumType>> apiAlbumtypeGet();
}
