package com.gridnine.testing;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

abstract class СonditionFlight{
    protected List<Flight> flightList;
    public СonditionFlight(List<Flight> flightList) {
        this.flightList = flightList;
    }

    protected abstract Predicate<Flight> flightPredicate();

    public List<Flight> getMeetsСonditionList() {
        return flightList.stream().filter(flightPredicate()).collect(Collectors.toList());
    }
}
