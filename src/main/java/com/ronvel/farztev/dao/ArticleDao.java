package com.ronvel.farztev.dao;

import org.springframework.data.repository.CrudRepository;
import com.ronvel.farztev.dao.model.ArticleModel;

public interface ArticleDao extends CrudRepository<ArticleModel, Long> {
	
}
