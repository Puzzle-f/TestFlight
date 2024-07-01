package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;


public class TestFilters {
    List<Flight> flightList;
    FilterInstance filterFly;

    @BeforeEach
    void setUp() {
        flightList = FlightBuilder.createFlights();
        filterFly = new FilterInstance(FlightBuilder.createFlights());
    }

    @Test
    public void test_Get_Departure_Before_Current_Time() {
        String ListControl = List.of(//A normal flight with two hour duration
                FlightBuilder.createFlights().get(0),
                //A normal multi segment flight
                FlightBuilder.createFlights().get(1),
                //A flight that departs before it arrives
                FlightBuilder.createFlights().get(3),
                //A flight with more than two hours ground time
                FlightBuilder.createFlights().get(4),
                //Another flight with more than two hours ground time
                FlightBuilder.createFlights().get(5)).toString();

        Assertions.assertEquals(
                filterFly.getDepartureBeforeCurrentTime().getList().toString(),
                ListControl
        );
    }

    @Test
    public void test_Get_Arrival_Before_Departure() {
        String ListControl = List.of(
                //A normal flight with two hour duration
                FlightBuilder.createFlights().get(0),
                //A normal multi segment flight
                FlightBuilder.createFlights().get(1),
                //A flight departing in the past
                FlightBuilder.createFlights().get(2),
                //A flight with more than two hours ground time
                FlightBuilder.createFlights().get(4),
                //Another flight with more than two hours ground time
                FlightBuilder.createFlights().get(5)).toString();

        Assertions.assertEquals(
                filterFly.getArrivalBeforeDeparture().getList().toString(),
                ListControl
        );
    }

    @Test
    public void test_Get_Time_On_Earth_Does_Not_Exceed_2_Hours() {
        String ListControl = List.of(
                //A normal flight with two hour duration
                FlightBuilder.createFlights().get(0),
                //A normal multi segment flight
                FlightBuilder.createFlights().get(1),
                //A flight departing in the past
                FlightBuilder.createFlights().get(2),
                //A flight that departs before it arrives
                FlightBuilder.createFlights().get(3)).toString();

        Assertions.assertEquals(
                filterFly.getTimeOnEarthDoesNotExceed2Hours().getList().toString(),
                ListControl
        );
    }
}
