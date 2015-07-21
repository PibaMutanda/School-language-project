package be.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import be.school.repository.jpa.ParticipantRepositoryJpa;

@Service
@Scope("singleton")
public class ParticipantService {
	
	@Autowired
	private ParticipantRepositoryJpa participantRepositoryJpa;
	
	

}
