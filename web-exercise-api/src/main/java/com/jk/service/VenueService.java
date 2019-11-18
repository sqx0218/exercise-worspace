package com.jk.service;



import com.jk.model.Venue;

import java.util.List;

public interface VenueService {
    List<Venue> queryFootballVenue(String typeName);
}
