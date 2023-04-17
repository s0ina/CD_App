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
import com.example.CD_app.domain.Artist;
import com.example.CD_app.domain.ArtistRepository;

@Controller
public class ArtistController {


	//Palauttaa listan kaikista artisteista
	
	@Autowired
	ArtistRepository artistrepository; 
	@RequestMapping(value = "/artistlist", method = RequestMethod.GET)
	public String getArtists(Model model){
		List<Artist> artists =  (List<Artist>) artistrepository.findAll();
		model.addAttribute("artists", artists);
		return "artistlist";
	}
	//poistaa artistin id:llä
	@RequestMapping(value = "/deleteartist/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteArtist(@PathVariable("id") Long artist_Id, Model model) {
		artistrepository.deleteById(artist_Id);
		return "redirect:/artistlist";
	} 
	//lisää artistin
	@RequestMapping(value = "/addartist", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String getNewArtistForm(Model model) {
		model.addAttribute("artist", new Artist()); 
		return "/addartist";
	}
	//tallentaa artistin
	@RequestMapping(value = "/saveartist", method = RequestMethod.POST)
	public String saveArtist(@ModelAttribute Artist artist) {
		artistrepository.save(artist);
		return "redirect:/artistlist";
	}
	//Palautta json-listan kaikista artisteista
	@RequestMapping(value="/api/artists", method = RequestMethod.GET)
	public @ResponseBody List<Artist> ArtistListRest() {
		return (List<Artist>) artistrepository.findAll();
	}
	//hakee artistin id:llä
	@RequestMapping(value="/api/artists/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Artist> findArtistRest(@PathVariable("id") Long artist_Id) {	
		return artistrepository.findById(artist_Id);
	}      

	//lisää uuden artistin
	@PostMapping("/api/artists/addartist")
	Artist newArtist(@RequestBody Artist newArtist) {
		return artistrepository.save(newArtist);
	}
	//poistaa artistin id:llä
	@DeleteMapping("/api/artists/{id}")
	public Iterable<Artist> deleteArtist(@PathVariable("id") Long artist_Id) {
		artistrepository.deleteById(artist_Id);
		return artistrepository.findAll();
	}

	//muokkaa artistia id:llä
	@PutMapping("/api/artists/{id}")
	public Artist editArtist(@RequestBody Artist editedArtist, @PathVariable("id") Long artist_Id) {
		editedArtist.setId(artist_Id);
		return artistrepository.save(editedArtist);
	}


}



