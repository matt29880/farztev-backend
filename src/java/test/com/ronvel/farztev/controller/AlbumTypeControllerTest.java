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
import com.ronvel.farztev.controller.dto.AlbumType;
import com.ronvel.farztev.controller.dto.ListAlbumType;

public class AlbumTypeControllerTest extends BaseControllerTest {
  
  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void albumTypesGet() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<List<ListAlbumType>> albumTypesResponse = this.restTemplate.exchange("/api/albumtype",
        HttpMethod.GET, request, new ParameterizedTypeReference<List<ListAlbumType>>() {});
    assertTrue(albumTypesResponse.getStatusCode().is2xxSuccessful());
  }

  @Test
  public void albumTypesAlbumIdGet() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<AlbumType> albumTypeResponse = this.restTemplate.exchange("/api/albumtype/1",
        HttpMethod.GET, request, new ParameterizedTypeReference<AlbumType>() {});
    assertTrue(albumTypeResponse.getStatusCode().is2xxSuccessful());
  }

  @Test
  public void albumTypesAlbumIdGet_notExisting() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<AlbumType> albumResponse = this.restTemplate.exchange("/api/albumtype/0",
        HttpMethod.GET, request, new ParameterizedTypeReference<AlbumType>() {});
    assertTrue(albumResponse.getStatusCode().is4xxClientError());
  }

}
