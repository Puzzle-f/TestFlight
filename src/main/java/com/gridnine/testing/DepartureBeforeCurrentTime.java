package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;


public class DepartureBeforeCurrentTime extends СonditionFlight {
    LocalDateTime currentData = LocalDateTime.now();
    List<Flight> flights;
    @Override
    protected Predicate<Flight> flightPredicate(){
       return flight -> {
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size() ; i++) {
                if (segments.get(i).getDepartureDate().isBefore(currentData)) {
                    return false;
                }
            }
            return true;
        };
    }

    public DepartureBeforeCurrentTime(List<Flight> flight) {
        super(flight);
        this.flights = flight;
    }
}


