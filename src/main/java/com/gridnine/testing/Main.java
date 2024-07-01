package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {

        FilterInstance filterFly = new FilterInstance(FlightBuilder.createFlights());

        System.out.println(filterFly.getDepartureBeforeCurrentTime().getList());
        System.out.println(filterFly.getArrivalBeforeDeparture().getList());
        System.out.println(filterFly.getTimeOnEarthDoesNotExceed2Hours().getList());

//    Данная реализация позволяет осуществлять фильтрацию по нескольким критериям:
        filterFly.getDepartureBeforeCurrentTime()
                .getArrivalBeforeDeparture()
                .getTimeOnEarthDoesNotExceed2Hours()
                .getList();
    }



}