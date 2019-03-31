package com.ronvel.farztev.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import com.ronvel.farztev.controller.ArticleController;
import com.ronvel.farztev.controller.dto.Article;
import com.ronvel.farztev.controller.dto.ListArticle;
import com.ronvel.farztev.service.ArticleService;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2017-09-07T23:10:06.754+02:00")

@Controller
public class ArticleControllerImpl implements ArticleController {

  @Autowired
  private ArticleService articleService;

  public ResponseEntity<Article> apiArticleArticleIdGet(
      @ApiParam(value = "Article ID", required = true) @PathVariable("articleId") Long articleId) {
    ResponseEntity<Article> response;

    Optional<Article> optionalArticle = articleService.findArticleById(articleId);
    if (optionalArticle.isPresent()) {
      response = new ResponseEntity<Article>(optionalArticle.get(),HttpStatus.OK);
    } else {
      response = new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
    }

    return response;
  }
  public ResponseEntity<List<ListArticle>> apiArticleGet() {
    List<ListArticle> listArticles = articleService.listArticles();
    return new ResponseEntity<List<ListArticle>>(listArticles,HttpStatus.OK);
  }
}
