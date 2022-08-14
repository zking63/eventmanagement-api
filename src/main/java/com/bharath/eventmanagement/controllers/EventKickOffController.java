package com.bharath.eventmanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bharath.eventmanagement.entities.Event;
import com.bharath.eventmanagement.repos.EventRepository;

@RepositoryRestController

public class EventKickOffController {
	
	@Autowired
	private EventRepository eventRepository;
	
	@PostMapping("/events/start/{id}")
	public ResponseEntity start(@PathVariable Long id) {
		Optional<Event> event = eventRepository.findById(id);
		
		if (event == null) {
			throw new ResourceNotFoundException();
		}
		Event e= event.get();
		e.setStarted(true);
		eventRepository.save(e);
		
		return ResponseEntity.ok(e.getName() + " has started");
	}
}
