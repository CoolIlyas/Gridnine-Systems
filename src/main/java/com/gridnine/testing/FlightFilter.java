package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class FlightFilter {
    public static List<Flight> departureDateBeforeNow (List<Flight> flights){
        ArrayList <Flight> newFlights = new ArrayList<>(flights);
        LocalDateTime now = LocalDateTime.now();
        newFlights.removeIf(flight -> (now.until(flight.getSegments().get(0).getDepartureDate(), ChronoUnit.MILLIS) < 0));
        return newFlights;
    }
    public static List<Flight> arrivalBeforeDeparture (List<Flight> flights){
        ArrayList <Flight> newFlights = new ArrayList<>(flights);
        ListIterator<Flight> listIter = newFlights.listIterator();
        while(listIter.hasNext()) {
            Flight currentflight = listIter.next();
            for (int i = 0; i < currentflight.getSegments().size(); i++) {
                LocalDateTime currentDepartureTime = currentflight.getSegments().get(i).getDepartureDate();
                LocalDateTime currentArrivalTime = currentflight.getSegments().get(i).getArrivalDate();
                if (currentDepartureTime.until(currentArrivalTime, ChronoUnit.MILLIS) < 0) {
                    listIter.remove();
                    break;
                }
            }
        }
        return newFlights;
    }
    public static List<Flight> bigBreak (List<Flight> flights){
        ArrayList <Flight> newFlights = new ArrayList<>(flights);
        ListIterator<Flight> listIter = newFlights.listIterator();
        while(listIter.hasNext()) {
            Flight currentflight = listIter.next();
            for (int i = 1; i < currentflight.getSegments().size(); i++) {
                LocalDateTime currentDepartureTime = currentflight.getSegments().get(i).getDepartureDate();
                LocalDateTime currentArrivalTime = currentflight.getSegments().get(i-1).getArrivalDate();
                if (currentArrivalTime.until(currentDepartureTime, ChronoUnit.HOURS) >= 2) {
                    listIter.remove();
                    break;
                }
            }
        }
        return newFlights;
    }
}
