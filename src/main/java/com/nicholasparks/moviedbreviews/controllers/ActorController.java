package com.nicholasparks.moviedbreviews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nicholasparks.moviedbreviews.models.Actor;
import com.nicholasparks.moviedbreviews.services.ActorService;

@Controller
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	
	//Display list of Actors
	@GetMapping("/actors")
	public String viewActors(Model model) {
		model.addAttribute("listActors", actorService.getAllActors());
		return "actors";
	}
	
	@GetMapping("/addActorForm")
	public String newActorFrom(Model model) {
		Actor actor = new Actor();
		model.addAttribute("actor", actor);
		return "new_actor";
	}

	@PostMapping("/saveActor")
	public String saveActor(@ModelAttribute("actor") Actor actor) {
		// save the new actor to the database
		actorService.saveActor(actor);
		return "redirect:/actors";
	}
	
	@GetMapping("/actorUpdateForm/{id}")
	public String actorUpdateForm(@PathVariable (value = "id") Long actorId, Model model) {
		// Get actor from service
		Actor actor = actorService.getActorById(actorId);
		// Set actor as model attribute to pre-populate the form
		model.addAttribute("actor", actor);
		return "update_actor";
	}
	
	@GetMapping("/deleteActor/{id}")
	public String deleteActor(@PathVariable (value = "id") Long actorId) {
		// call delete actor method
		this.actorService.deleteActorById(actorId);
		return "redirect:/actors";
	}
}
