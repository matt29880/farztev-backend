package com.ronvel.farztev.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.ronvel.farztev.dao.model.MediaModel;

public interface MediaDao extends CrudRepository<MediaModel, Long> {

  List<MediaModel> findByAlbumId(Long albumId);
	
}
