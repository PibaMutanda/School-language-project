package be.school.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import be.school.model.DetailLocalFormation;
import be.school.model.Formation;
import be.school.model.Participant;
import be.school.repository.ParticipantRepository;

/**
 * ParticipantService class
 * 
 * @author P. Mutanda
 *
 */
@Service
@Scope("singleton")
public class ParticipantService {

	@Autowired
	private ParticipantRepository participantRepository;

	/**
	 * 
	 * @param participant
	 *            participant
	 * @param formation
	 *            formation
	 * @return retourne vrai si participant est inscrit pour la formation
	 */
	public boolean isRegistered(Participant participant, Formation formation) {
		boolean ok = false;
		Set<DetailLocalFormation> listeDet = participant
				.getDetailLocalFormations();
		for (DetailLocalFormation detailLocalFormation : listeDet) {
			if (detailLocalFormation.getFormation().getId() == formation
					.getId())
				ok = true;
			break;
		}
		return ok;
	}

	/**
	 * 
	 * @param formation
	 *            formation
	 * @return retourne la liste des participants
	 */
	public List<Participant> getParticipantsListForRegistration(
			Formation formation) {
		List<Participant> resultList = new ArrayList<Participant>();
		/*
		 * Firstly get all new participant then put them to the result list
		 */
		List<Participant> newParticantList = participantRepository
				.findAllNews();
		for (Participant participant : newParticantList) {
			resultList.add(participant);
		}
		/*
		 * Secondly find and exclude participants who already are registered for 2
		 * courses
		 */

		List<Participant> oldParticipants = participantRepository.findAll();
		List<Participant> oldSortParticipants = new ArrayList<Participant>();
		for (Participant participant : oldParticipants) {
			if (participant.getDetailLocalFormations().size() < 2) {
				oldSortParticipants.add(participant);
			}
		}

		/*
		 * after, exclude participants who are already registered for a course
		 */
		for (Participant participant : oldSortParticipants) {
			if (!isRegistered(participant, formation)
					&& participant.getLocal() != null)
				resultList.add(participant);
		}
		return resultList;
	}
}
