package com.bharath.eventmanagement.entities.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.bharath.eventmanagement.entities.Venue;

@Projection(name="virtual", types = { Venue.class })
public interface StreetAddressProjection {
	
	@Value("#{target.StreetAddress} #{target.StreetAddress2}")
	String getCompleteStreetAddress();
}
