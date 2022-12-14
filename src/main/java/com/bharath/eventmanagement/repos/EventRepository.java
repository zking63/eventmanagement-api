package com.bharath.eventmanagement.repos;


import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.bharath.eventmanagement.entities.Event;
import com.bharath.eventmanagement.entities.projections.PartialEventProjection;

@RepositoryRestResource(excerptProjection=PartialEventProjection.class)
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	Page<Event> findByName(@Param("name")String name, Pageable pageable);
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void deleteById(Long id);

}
