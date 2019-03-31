package com.ronvel.farztev.controller;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import com.ronvel.farztev.controller.dto.Album;
import com.ronvel.farztev.controller.dto.ListAlbum;

public class AlbumControllerTest extends BaseControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void albumsGet() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<List<ListAlbum>> albumsResponse = this.restTemplate.exchange("/api/album",
        HttpMethod.GET, request, new ParameterizedTypeReference<List<ListAlbum>>() {});
    assertTrue(albumsResponse.getStatusCode().is2xxSuccessful());
  }
  
  @Test
  public void albumsAlbumIdGet() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<Album> albumResponse = this.restTemplate.exchange("/api/album/1",
        HttpMethod.GET, request, new ParameterizedTypeReference<Album>() {});
    assertTrue(albumResponse.getStatusCode().is2xxSuccessful());
  }

  @Test
  public void albumsAlbumIdGet_notExisting() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<Album> albumResponse = this.restTemplate.exchange("/api/album/0",
        HttpMethod.GET, request, new ParameterizedTypeReference<Album>() {});
    assertTrue(albumResponse.getStatusCode().is4xxClientError());
  }

}
