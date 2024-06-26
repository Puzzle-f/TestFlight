package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {
        System.out.println(new FilterFlight(FlightBuilder.createFlights()).getDepartureBeforeCurrentTime());
        System.out.println(new ArrivalBeforeDeparture(FlightBuilder.createFlights()).getMeetsСonditionList());
        System.out.println(new TimeOnEarthDoesNotExceed2Hours(FlightBuilder.createFlights()).getMeetsСonditionList());

    }


}