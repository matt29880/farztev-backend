package com.ronvel.farztev.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ronvel.farztev.controller.dto.ListMedia;
import com.ronvel.farztev.controller.dto.Media;

public class MediaServiceTest extends BaseServiceTest {

  @Autowired
  private MediaService mediaService;

  @Test
  public void findMedia() {
    Optional<Media> optionalMedia = mediaService.findMediaById(1L);
    assertTrue(optionalMedia.isPresent());
  }

  @Test
  public void findMedia_notFound() {
    Optional<Media> optionalMedia = mediaService.findMediaById(0L);
    assertFalse(optionalMedia.isPresent());
  }

  @Test
  public void listMedias() {
    List<ListMedia> medias = mediaService.listMedias();
    assertEquals(1, medias.size());
  }

  @Test
  public void listAlbumMedias() {
    List<ListMedia> medias = mediaService.listAlbumMedias(1L);
    assertEquals(1, medias.size());
  }

}
