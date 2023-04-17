package com.example.CD_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.CD_app.domain.Album;
import com.example.CD_app.domain.AlbumRepository;
import com.example.CD_app.domain.ArtistRepository;
import com.example.CD_app.domain.Category;
import com.example.CD_app.domain.CategoryRepository;
import com.example.CD_app.domain.User;
import com.example.CD_app.domain.Artist;
import com.example.CD_app.domain.UserRepository;

@SpringBootApplication
public class CdAppApplication {
	private static final Logger log = LoggerFactory.getLogger(CdAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CdAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner Artist(ArtistRepository repository, CategoryRepository crepository, AlbumRepository arepository, UserRepository userrepository) {
		return (args) -> {
			log.info("save a couple of albums");
			
			Category category1 = new Category("Trip-hop");
			Category category2 = new Category("Post-punk");
			Category category3 = new Category("Rock");
			Category category4 = new Category("Pop");
			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);
			crepository.save(category4);
			
			Artist artist1 = new Artist("The Cure", "GB", 1976);
			Artist artist2 = new Artist("Massive Attack", "GB", 1988);
			Artist artist3 = new Artist("Depeche Mode", "GB", 1980);
			Artist artist4 = new Artist("Emma Ruth Rundle", "USA", 2008);
			repository.save(artist1);
			repository.save(artist2);
			repository.save(artist3);
			repository.save(artist4);
			
			Album album1 = new Album("Faith", 1981, category1, artist1);
			Album album2 = new Album("Mezzanine", 1998, category2, artist2);
			Album album3 = new Album("Engine Of Hell", 2021, category3, artist4);
			Album album4 = new Album("Songs Of Faith And Devotion", 1993, category4, artist3);
			arepository.save(album1);
			arepository.save(album2);
			arepository.save(album3);
			arepository.save(album4);

			// admin : 1234
			User user1 = new User("admin", "$2a$10$mjR/A4QE/.d2HNEsejKUM.WeyIlukyo52jRxL5o.lcFjz/ZwyU5o6", "ADMIN");
			userrepository.save(user1);
			// user : user
			User user2 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			userrepository.save(user2);

			log.info("fetch all albums");
			for (Album album : arepository.findAll()) {
				log.info(album.toString());
			}
		};
	}
}


