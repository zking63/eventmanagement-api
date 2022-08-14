package com.bharath.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bharath.eventmanagement.entities.Venue;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

}
