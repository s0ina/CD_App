package com.example.CD_app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long album_Id;
	private String album_name;
	private int album_year;
	
	@ManyToOne
	@JsonIgnoreProperties ("albums") 
	@JoinColumn(name = "artist_Id")
	
	private Artist artist;

	public Artist getArtist() {
		return artist;
	}
	
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	@ManyToOne
	@JsonIgnoreProperties ("albums") 
	@JoinColumn(name = "category_Id")
	private Category category;
	

	public Long getAlbum_Id() {
		return album_Id;
	}
	
	public void setAlbum_Id(Long album_Id) {
		this.album_Id = album_Id;
	}
	
	public String getAlbum_name() {
		return album_name;
	}
	
	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}
	
	public int getAlbum_year() {
		return album_year;
	}
	
	public void setAlbum_year(int album_year) {
		this.album_year = album_year;
	}

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public Album(String album_name, int album_year, Category category, Artist artist) {
		super();
		this.album_name = album_name;
		this.album_year = album_year;
		this.category = category;
		this.artist = artist;
	}

	public Album() {
		super();
		this.album_name = null;
		this.album_year = 0;
		this.category = null;
		this.artist = null;
	}
	@Override
	public String toString() {
		return "Album [album_Id=" + album_Id + ", album_name=" + album_name + ", album_year=" + album_year + ", category=" + category + "]";
	}





}
