package com.ronvel.farztev.service;

import java.util.List;
import java.util.Optional;
import com.ronvel.farztev.controller.dto.Album;
import com.ronvel.farztev.controller.dto.ListAlbum;

/**
 * Service for selecting albums.
 * 
 * @author mronvel
 *
 */
public interface AlbumService {
	/**
	 * Find an article by id.
	 * 
	 * @param id
	 * @return
	 */
	Optional<Album> findAlbumById(Long id);

	/**
	 * List all the articles.
	 * 
	 * @return
	 */
	List<ListAlbum> listAlbums();
}
