package com.ronvel.farztev.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ronvel.farztev.controller.dto.Album;
import com.ronvel.farztev.controller.dto.ListAlbum;

public class AlbumServiceTest extends BaseServiceTest {

  @Autowired
  private AlbumService albumService;

  @Test
  public void findAlbum() {
    Optional<Album> optionalAlbum = albumService.findAlbumById(1L);
    assertTrue(optionalAlbum.isPresent());
  }

  @Test
  public void findAlbum_notAvailable() {
    Optional<Album> optionalAlbum = albumService.findAlbumById(0L);
    assertFalse(optionalAlbum.isPresent());
  }

  @Test
  public void listAlbums() {
    List<ListAlbum> albums = albumService.listAlbums();
    assertEquals(1, albums.size());
  }

}
