package com.example.CD_app.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AuthorsRepository extends CrudRepository<Authors, Long> {
	Optional<Authors> findById(Long authors_Id);
}

