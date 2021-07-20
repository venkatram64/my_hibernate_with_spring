package com.venkat;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MyFilterEg {
    public static void main(String[] args) {
        class Stop {
            private final String stationName;
            private final int    passengerCount;

            Stop(final String stationName, final int passengerCount) {
                this.stationName    = stationName;
                this.passengerCount = passengerCount;
            }

            @Override
            public String toString() {
                return "Stop{" +
                        "stationName='" + stationName + '\'' +
                        ", passengerCount=" + passengerCount +
                        '}';
            }
        }

        List<Stop> stops = new LinkedList<>();

        stops.add(new Stop("Station1", 250));
        stops.add(new Stop("Station2", 275));
        stops.add(new Stop("Station3", 390));
        stops.add(new Stop("Station2", 210));
        stops.add(new Stop("Station1", 190));

        List<Stop> fstops = new LinkedList<>();

        Stop firstStopAtStation1 = stops.stream()
                .filter(e -> e.stationName.equals("Station1"))
                .findFirst()
                .orElse(null);

        System.out.printf("At the first stop at Station1 there were %d passengers in the train.", firstStopAtStation1.passengerCount);
        System.out.println();
        fstops.addAll(stops.stream().filter(s -> s.stationName.equals("Station11")).collect(Collectors.toList()));
        System.out.println(fstops);


    }
}
