package com.example.CD_app.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {
	Optional<Album> findById(Long album_Id);
}

