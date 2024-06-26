package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

public class TimeOnEarthDoesNotExceed2Hours extends СonditionFlight  {
    List<Flight> flights;
    int limitTimeHours = 2;

    public TimeOnEarthDoesNotExceed2Hours(List<Flight> flight) {
        super(flight);
        this.flights = flight;
    }

    @Override
    protected Predicate<Flight> flightPredicate(){
        return flight -> {
            List<Segment> segments = flight.getSegments();
                int countTimeMin = 0;
                for (int i = 0; i < segments.size() ; i++) {
                    if(i < segments.size()-1){
                        LocalDateTime startPeriod = segments.get(i).getArrivalDate();
                        LocalDateTime endPeriod = segments.get(i+1).getDepartureDate();
                        countTimeMin += (int) Duration.between(startPeriod, endPeriod).toMinutes();
                    }
                }
                if (countTimeMin/60 > limitTimeHours) return false;
                else return true;
        };
    }



}
