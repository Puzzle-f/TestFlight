package com.gridnine.testing;

public interface FilterFly <T extends FilterBase>{
    T getArrivalBeforeDeparture();
    T getDepartureBeforeCurrentTime();
    T getTimeOnEarthDoesNotExceed2Hours();
}
