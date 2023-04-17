package com.example.CD_app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.CD_app.domain.Artist;
import com.example.CD_app.domain.ArtistRepository;

public class ArtistRepositoryTest {
	
	@Autowired
	ArtistRepository artistrepository;
	
	@Test
	public void createArtist() {
	
	Artist artist1 = new Artist("Massive Attack", "GB", 1988);
	artistrepository.save(artist1);
	
	assertThat(artist1.getArtist_name()).isNotNull();
}

}
