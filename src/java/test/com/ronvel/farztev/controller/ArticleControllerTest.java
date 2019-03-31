package com.ronvel.farztev.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import com.ronvel.farztev.controller.dto.Article;
import com.ronvel.farztev.controller.dto.ListArticle;
import com.ronvel.farztev.dao.model.ArticleModel;
import com.ronvel.farztev.service.ArticleServiceTest;
import com.ronvel.farztev.service.BaseServiceTest;

public class ArticleControllerTest extends BaseControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;
  
  @Test
  public void articlesGet() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<List<ListArticle>> articlesResponse = this.restTemplate.exchange("/api/article",
        HttpMethod.GET, request, new ParameterizedTypeReference<List<ListArticle>>() {});
    assertTrue(articlesResponse.getStatusCode().is2xxSuccessful());
  }

  @Test
  public void articlesArticleIdGet() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<Article> articleResponse = this.restTemplate.exchange("/api/article/1",
        HttpMethod.GET, request, new ParameterizedTypeReference<Article>() {});
    assertTrue(articleResponse.getStatusCode().is2xxSuccessful());
  }

  @Test
  public void articlesArticleIdGet_notExisting() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(headers);

    ResponseEntity<Article> articleResponse = this.restTemplate.exchange("/api/article/0",
        HttpMethod.GET, request, new ParameterizedTypeReference<Article>() {});
    assertTrue(articleResponse.getStatusCode().is4xxClientError());
  }

}
