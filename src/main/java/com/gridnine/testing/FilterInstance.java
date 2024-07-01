package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

class FilterInstance extends FilterBase implements FilterFly {
    List<Flight> flightsInstance;

    FilterInstance(List<Flight> flightsInstance) {
        this.flightsInstance = flightsInstance;
    }

    public  List<Flight> getList() {
        return flightsInstance;
    }


    public FilterInstance getArrivalBeforeDeparture() {
        return new FilterInstance(flightsInstance.stream().filter(flight -> {
            List<Segment> segments = flight.getSegments();
            for (Segment segment : segments) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    return false;
                }
            }
            return true;
        }).collect(Collectors.toList())
        );
    }

    public FilterInstance getDepartureBeforeCurrentTime() {
        LocalDateTime currentData = LocalDateTime.now();
        return new FilterInstance(flightsInstance.stream().filter(flight -> {
            List<Segment> segments = flight.getSegments();
            for (Segment segment : segments) {
                if (segment.getDepartureDate().isBefore(currentData)) {
                    return false;
                }
            }
            return true;
        }).collect(Collectors.toList()));
    }

    public FilterInstance getTimeOnEarthDoesNotExceed2Hours() {
        int limitTimeHours = 2;
        return new FilterInstance(flightsInstance.stream().filter(flight -> {
            List<Segment> segments = flight.getSegments();
            int countTimeMin = 0;
            for (int i = 0; i < segments.size(); i++) {
                if (i < segments.size() - 1) {
                    LocalDateTime startPeriod = segments.get(i).getArrivalDate();
                    LocalDateTime endPeriod = segments.get(i + 1).getDepartureDate();
                    countTimeMin += (int) Duration.between(startPeriod, endPeriod).toMinutes();
                }
            }
            return countTimeMin / 60 <= limitTimeHours;
        }).collect(Collectors.toList()));
    }
}




