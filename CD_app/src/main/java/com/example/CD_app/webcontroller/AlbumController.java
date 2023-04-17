package com.example.CD_app.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.CD_app.domain.Album;
import com.example.CD_app.domain.AlbumRepository;
import com.example.CD_app.domain.CategoryRepository;


@Controller
public class AlbumController {

	@Autowired
	private CategoryRepository crepository; 

	//Palauttaa kaikki albumit
	@Autowired
	AlbumRepository albumrepository; 
	@RequestMapping(value = "/albumlist", method = RequestMethod.GET)
	public String getAlbums(Model model){
		List<Album> albums =  (List<Album>) albumrepository.findAll();
		model.addAttribute("albums", albums);
		return "albumlist";
	}

	//Poistaa albumin id:llä
	@RequestMapping(value = "/deletealbum/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteAlbum(@PathVariable("id") Long album_Id, Model model) {
		albumrepository.deleteById(album_Id);
		return "redirect:/albumlist";
	} 
	//Lisää albumin
	@RequestMapping(value = "/addalbum", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String getNewAlbumForm(Model model) {
		model.addAttribute("album", new Album()); 
		return "/addalbum";
	}
	//Tallentaa albumin
	@RequestMapping(value = "/savealbum", method = RequestMethod.POST)
	public String saveAlbum(@ModelAttribute Album album) {
		albumrepository.save(album);
		return "redirect:/albumlist";
	}
	//Palauttaa json-listan kaikista albumeista
	@RequestMapping(value="/api/albums", method = RequestMethod.GET)
	public @ResponseBody List<Album> AlbumListRest() {	
		return (List<Album>) albumrepository.findAll();
	}
	//Hakee albumin id:llä
	@RequestMapping(value="/api/albums/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Album> findAlbumRest(@PathVariable("id") Long album_Id) {	
		return albumrepository.findById(album_Id);
	}      

	//lisää albumin
	@PostMapping("/api/albums/addalbums")
	Album newAlbum(@RequestBody Album newAlbum) {
		return albumrepository.save(newAlbum);
	}
	//poistaa albumin id:llä
	@DeleteMapping("/api/albums/{id}")
	public Iterable<Album> deleteAlbum(@PathVariable("id") Long album_Id) {
		albumrepository.deleteById(album_Id);
		return albumrepository.findAll();
	}

	//Muokkaa albumia
	@PutMapping("/api/albums/{id}")
	public Album editAlbum(@RequestBody Album editedAlbum, @PathVariable("id") Long album_Id) {
		editedAlbum.setAlbum_Id(album_Id);
		return albumrepository.save(editedAlbum);
	}


}
