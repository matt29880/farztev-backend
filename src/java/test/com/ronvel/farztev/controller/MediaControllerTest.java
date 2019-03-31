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
import com.ronvel.farztev.controller.dto.ListMedia;
import com.ronvel.farztev.controller.dto.Media;

public class MediaControllerTest extends BaseControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void mediasGet() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<List<ListMedia>> mediasResponse =
        this.restTemplate.exchange("/api/album/1/media", HttpMethod.GET, request,
            new ParameterizedTypeReference<List<ListMedia>>() {});
    assertTrue(mediasResponse.getStatusCode().is2xxSuccessful());
  }

  @Test
  public void mediasMediaIdGet() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<Media> mediaResponse =
        this.restTemplate.exchange("/api/album/1/media/1", HttpMethod.GET, request,
            new ParameterizedTypeReference<Media>() {});
    assertTrue(mediaResponse.getStatusCode().is2xxSuccessful());
  }

  @Test
  public void mediasMediaIdGet_notExisting() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<Media> mediaResponse = this.restTemplate.exchange("/api/album/1/media/2",
        HttpMethod.GET, request, new ParameterizedTypeReference<Media>() {});
    assertTrue(mediaResponse.getStatusCode().is4xxClientError());
  }

}
