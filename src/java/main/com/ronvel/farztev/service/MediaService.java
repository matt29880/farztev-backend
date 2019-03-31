package com.ronvel.farztev.service;

import java.util.List;
import java.util.Optional;
import com.ronvel.farztev.controller.dto.ListMedia;
import com.ronvel.farztev.controller.dto.Media;

/**
 * Service for selecting medias.
 * 
 * @author mronvel
 *
 */
public interface MediaService {
	/**
	 * Find a media by id.
	 * 
	 * @param id
	 * @return
	 */
	Optional<Media> findMediaById(Long id);

	/**
	 * List all the medias.
	 * 
	 * @return
	 */
	List<ListMedia> listMedias();

    /**
     * List all the medias of an album.
     * 
     * @return
     */
    List<ListMedia> listAlbumMedias(Long albumId);
}
