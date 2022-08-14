package com.bharath.eventmanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bharath.eventmanagement.controllers.exceptions.AlreadyCheckedInException;
import com.bharath.eventmanagement.entities.Participant;
import com.bharath.eventmanagement.repos.ParticipantRepository;

@RepositoryRestController
public class CheckInController {
	@Autowired
	private ParticipantRepository participantRepository;

	@PostMapping("/events/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler){
		
		Optional<Participant> participant = participantRepository.findById(id);
		Participant p = participant.get();
		if(participant != null) {
			p = participant.get();
			
			if(p.getCheckedIn()) {
				throw new AlreadyCheckedInException();
			}
			p.setCheckedIn(true);
			participantRepository.save(p);
			
		}
		return ResponseEntity.ok(assembler.toFullResource(p));
	}
}
