package com.ronvel.farztev.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Optional;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ronvel.farztev.controller.dto.Article;
import com.ronvel.farztev.controller.dto.ListArticle;

public class ArticleServiceTest extends BaseServiceTest {

  @Autowired
  private ArticleService articleService;
  
  @Test
  public void findArticle() {
    Optional<Article> optionalArticle = articleService.findArticleById(1L);
    assertTrue(optionalArticle.isPresent());
  }

  @Test
  public void findArticle_notFound() {
    Optional<Article> optionalArticle = articleService.findArticleById(0L);
    assertFalse(optionalArticle.isPresent());
  }

  @Test
  @FlywayTest(invokeCleanDB = true, locationsForMigrate = {"/db/testdata"})
  public void listArticles() {
    List<ListArticle> articles = articleService.listArticles();
    assertEquals(1L, articles.size());
  }
}
