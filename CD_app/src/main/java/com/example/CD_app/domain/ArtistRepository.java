package com.example.CD_app.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
	Optional<Artist> findById(Long artist_Id);
}
