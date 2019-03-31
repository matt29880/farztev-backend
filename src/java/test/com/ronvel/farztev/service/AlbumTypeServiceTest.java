package com.ronvel.farztev.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ronvel.farztev.controller.dto.AlbumType;
import com.ronvel.farztev.controller.dto.ListAlbumType;

public class AlbumTypeServiceTest extends BaseServiceTest {

  @Autowired
  private AlbumTypeService albumTypeService;
  
  @Test
  public void findAlbumTypeById() {
    Optional<AlbumType> optionalAlbumType = albumTypeService.findAlbumTypeById(1L);
    assertTrue(optionalAlbumType.isPresent());
  }

  @Test
  public void findAlbumTypeById_notFound() {
    Optional<AlbumType> optionalAlbumType = albumTypeService.findAlbumTypeById(0L);
    assertFalse(optionalAlbumType.isPresent());
  }

  @Test
  public void listAlbumTypes() {
    List<ListAlbumType> albumTypes = albumTypeService.listAlbumTypes();
    assertEquals(1, albumTypes.size());
  }

}
