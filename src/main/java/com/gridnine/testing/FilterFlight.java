package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FilterFlight {
    private List<Flight> flights;

    public FilterFlight(List<Flight> flights) {
        this.flights = flights;
    }

    public static class FilterInstance {
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
                for (int i = 0; i < segments.size(); i++) {
                    if (segments.get(i).getArrivalDate().isBefore(segments.get(i).getDepartureDate())) {
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
                for (int i = 0; i < segments.size(); i++) {
                    if (segments.get(i).getDepartureDate().isBefore(currentData)) {
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
                if (countTimeMin / 60 > limitTimeHours) return false;
                else return true;
            }).collect(Collectors.toList()));
        }
    }


}
