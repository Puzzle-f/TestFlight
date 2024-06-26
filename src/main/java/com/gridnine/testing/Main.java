package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new FilterFlight.FilterInstance(FlightBuilder.createFlights())
                .getArrivalBeforeDeparture()
                .getDepartureBeforeCurrentTime()
                .getTimeOnEarthDoesNotExceed2Hours()
                .getList());
    }


}