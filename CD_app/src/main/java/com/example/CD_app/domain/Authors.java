package com.example.CD_app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;


@Entity
public class Authors {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long authors_Id;
	
	@ManyToMany
	@JsonIgnoreProperties ("authors") 
	@JoinColumn(name = "album_Id")
	private Album album;
	
	@ManyToMany
	@JsonIgnoreProperties ("authors") 
	@JoinColumn(name = "artist_Id")
	private Artist artist;
	

	public Long getAuthors_Id() {
		return authors_Id;
	}

	public void setAuthors_Id(Long authors_Id) {
		this.authors_Id = authors_Id;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	

	
	

}
