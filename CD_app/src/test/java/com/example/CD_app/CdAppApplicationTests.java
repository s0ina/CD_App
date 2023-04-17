package com.example.CD_app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CD_app.webcontroller.AlbumController;

@SpringBootTest
class CdAppApplicationTests {
	
	@Autowired
	AlbumController albumcontroller;

	@Test
	void contextLoads() {

		assertThat(albumcontroller).isNotNull();
	}
	
	
}

