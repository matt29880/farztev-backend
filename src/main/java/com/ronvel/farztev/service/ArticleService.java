package com.ronvel.farztev.service;

import java.util.List;
import java.util.Optional;
import com.ronvel.farztev.controller.dto.Article;
import com.ronvel.farztev.controller.dto.ListArticle;

/**
 * Service for selecting articles.
 * 
 * @author mronvel
 *
 */
public interface ArticleService {
	/**
	 * Find an article by id.
	 * 
	 * @param id
	 * @return
	 */
	Optional<Article> findArticleById(Long id);

	/**
	 * List all the articles.
	 * 
	 * @return
	 */
	List<ListArticle> listArticles();
}
