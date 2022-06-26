package com.nicholasparks.moviedbreviews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nicholasparks.moviedbreviews.models.Director;
import com.nicholasparks.moviedbreviews.services.DirectorService;

@Controller
public class DirectorController {
	
	@Autowired
	private DirectorService directorService;
	
	// Display list of directors
	@GetMapping("/directors")
	public String viewDirectors(Model model) {
		model.addAttribute("listDirectors", directorService.getAllDirectors());
		return "directors";
	}
	
	@GetMapping("/addDirectorForm")
	public String newDirectorForm(Model model) {
		Director director = new Director();
		model.addAttribute("director", director);
		return "new_director";
	}
	
	@PostMapping("/saveDirector")
	public String saveMovie(@ModelAttribute("director") Director director) {
		// save the new director to the database
		directorService.saveDirector(director);
		return "redirect:/directors";
	}
	
	@GetMapping("/directorUpdateForm/{id}")
	public String directorUpdateForm(@PathVariable (value = "id") Long directorId, Model model) {
		// get director from service
		Director director = directorService.getDirectorById(directorId);
		// set director as model attribute to pre-populate the form
		model.addAttribute("director", director);
		return "update_director";
	}
	
	@GetMapping("/deleteDirector/{id}")
	public String deleteDirector(@PathVariable (value = "id") Long directorId) {
		// call delete director method
		this.directorService.deleteDirectorById(directorId);
		return "redirect:/directors";
	}

}
