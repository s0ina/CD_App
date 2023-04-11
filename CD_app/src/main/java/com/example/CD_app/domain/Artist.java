package com.example.CD_app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Artist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long artist_Id;
	private String artist_name;
	private String country;
	private int year_formed;
	
	public Long getId() {
		return artist_Id;
	}
	public void setId(Long id) {
		this.artist_Id = id;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getYear_formed() {
		return year_formed;
	}
	public void setYear_formed(int year_formed) {
		this.year_formed = year_formed;
	}
	public Artist(String artist_name, String country, int year_formed) {
		super();
		this.artist_name = artist_name;
		this.country = country;
		this.year_formed = year_formed;
	
	}
	
	public Artist() {
		super();
		this.artist_name = null;
		this.country= null;
		this.year_formed= 0;
	
		
	}
	@Override
	public String toString() {
		return "Artist [id=" + artist_Id + ", artist_name=" + artist_name + ", country=" + country + ", year_formed="
				+ year_formed + "]";
	}
	
	
	

}
