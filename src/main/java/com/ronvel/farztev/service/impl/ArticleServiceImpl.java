package com.ronvel.farztev.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ronvel.farztev.controller.dto.Article;
import com.ronvel.farztev.controller.dto.ListArticle;
import com.ronvel.farztev.dao.ArticleDao;
import com.ronvel.farztev.dao.model.ArticleModel;
import com.ronvel.farztev.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private ModelMapper mapper;

  @Autowired
  private ArticleDao articleDao;

  @Override
  public Optional<Article> findArticleById(Long id) {
    Optional<Article> optional;
    ArticleModel articleModel = articleDao.findOne(id);
    if (articleModel == null) {
      optional = Optional.empty();
    } else {
      Article article = mapper.map(articleModel, Article.class);
      optional = Optional.of(article);
    }
    return optional;
  }

  @Override
  public List<ListArticle> listArticles() {
    List<ListArticle> listArticles = new ArrayList<>();
    Iterable<ArticleModel> articles = articleDao.findAll();
    articles.forEach(article -> listArticles.add(mapper.map(article, ListArticle.class)));
    return listArticles;
  }
}
