package com.ronvel.farztev.service;

import java.util.List;
import java.util.Optional;
import com.ronvel.farztev.controller.dto.AlbumType;
import com.ronvel.farztev.controller.dto.ListAlbumType;
import com.ronvel.farztev.dao.model.AlbumTypeModel;

/**
 * Service for managing albums types.
 * 
 * @author mronvel
 *
 */
public interface AlbumTypeService {
  /**
   * Find an article type by id.
   * 
   * @param id
   * @return
   */
  Optional<AlbumType> findAlbumTypeById(Long id);

  /**
   * List all the articles.
   * 
   * @return
   */
  List<ListAlbumType> listAlbumTypes();

  /**
   * Map the album type model to the list of album type.
   * @param albumTypeModel
   * @return
   */
  ListAlbumType mapToListAlbumType(AlbumTypeModel albumTypeModel);
}
