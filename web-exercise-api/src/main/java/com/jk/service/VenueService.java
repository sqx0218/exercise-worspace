package com.jk.service;



import com.jk.model.Venue;

import java.util.List;

public interface VenueService {
    List<Venue> queryFootballVenue(String typeName);

    void addUserMakeVenue(Integer userId, Venue venue);

    Venue queryVenueById(Integer venueId);

    List<Venue> queryVenue();

    Venue getVenueById(Integer venueId);
}
