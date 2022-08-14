package com.bharath.eventmanagement.repos;


import org.springframework.data.repository.PagingAndSortingRepository;


import com.bharath.eventmanagement.entities.Participant;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {

}
