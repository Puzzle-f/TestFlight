package com.gridnine.testing;

import java.util.List;
import java.util.function.Predicate;

public class ArrivalBeforeDeparture extends СonditionFlight {

    List<Flight> flights;

    public ArrivalBeforeDeparture(List<Flight> flight) {
        super(flight);
        this.flights = flight;
    }

    @Override
    protected Predicate<Flight> flightPredicate() {
        return flight -> {
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size(); i++) {
                if (segments.get(i).getArrivalDate().isBefore(segments.get(i).getDepartureDate())) {
                    return false;
                }
            }
            return true;
        };
    }
}
