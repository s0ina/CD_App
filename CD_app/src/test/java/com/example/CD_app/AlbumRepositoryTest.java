package com.example.CD_app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.CD_app.domain.Album;
import com.example.CD_app.domain.AlbumRepository;
import com.example.CD_app.domain.Artist;
import com.example.CD_app.domain.ArtistRepository;
import com.example.CD_app.domain.Category;
import com.example.CD_app.domain.CategoryRepository;



public class AlbumRepositoryTest {
	
	@Autowired
	AlbumRepository albumrepository;
	
	@Autowired
	CategoryRepository categoryrepository;
	
	@Autowired
	ArtistRepository artistrepository;
	
	@Test
	public void createAlbum() {
		
		Category category1 = new Category("Trip-hop");
		categoryrepository.save(category1);
		
		Artist artist1 = new Artist("Massive Attack", "GB", 1988);
		artistrepository.save(artist1);
		
		Album testalbum = new Album("Mezzanine", 1998, category1, artist1);
		albumrepository.save(testalbum);
		assertThat(testalbum.getAlbum_Id()).isNotNull();
	}

}
