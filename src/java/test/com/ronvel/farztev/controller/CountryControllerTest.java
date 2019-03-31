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
import com.ronvel.farztev.controller.dto.Country;
import com.ronvel.farztev.controller.dto.ListCountry;

public class CountryControllerTest extends BaseControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;
  
  @Test
  public void countriesGet() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<List<ListCountry>> countriesResponse = this.restTemplate.exchange("/api/country",
        HttpMethod.GET, request, new ParameterizedTypeReference<List<ListCountry>>() {});
    assertTrue(countriesResponse.getStatusCode().is2xxSuccessful());
  }

  @Test
  public void countriesCountryIdGet() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<Country> countryResponse = this.restTemplate.exchange("/api/country/1",
        HttpMethod.GET, request, new ParameterizedTypeReference<Country>() {});
    assertTrue(countryResponse.getStatusCode().is2xxSuccessful());
  }

  @Test
  public void countriesCountryIdGet_notExisting() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<Country> countryResponse = this.restTemplate.exchange("/api/country/0",
        HttpMethod.GET, request, new ParameterizedTypeReference<Country>() {});
    assertTrue(countryResponse.getStatusCode().is4xxClientError());
  }
  
}
