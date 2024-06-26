package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FilterFlight {
    List<Flight> flights;

    public static List<Flight> build(FilterFlight filterFlight){
        return filterFlight.flights;
    }

    public FilterFlight(List<Flight> flights) {
        this.flights = flights;
    }

    public FilterFlight getArrivalBeforeDeparture() {
        return new FilterFlight (new ArrivalBeforeDeparture(flights).getMeetsСonditionList());
    }

    public FilterFlight getDepartureBeforeCurrentTime() {
        return new FilterFlight(new DepartureBeforeCurrentTime(flights).getMeetsСonditionList());
    }

    public List<Flight> getTimeOnEarthDoesNotExceed2Hours() {
        return new TimeOnEarthDoesNotExceed2Hours(FlightBuilder.createFlights()).getMeetsСonditionList();
    }




}
