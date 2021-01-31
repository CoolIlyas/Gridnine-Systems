package com.gridnine.testing;

import java.util.List;


public class Main {
    public static List<Flight> flights = FlightBuilder.createFlights();
    public static void main(String[] args){
        System.out.println("Список всех полетов:\n" + flights);
        System.out.println("Список полетов, где вылет до текущего момента времени:\n"+ FlightFilter.departureDateBeforeNow(flights));
        System.out.println("Список полетов, где имеются сегменты с датой прилёта раньше даты вылета:\n" +FlightFilter.arrivalBeforeDeparture(flights));
        System.out.println("Список полетов, где общее время, проведённое на земле превышает два часа:\n" + FlightFilter.bigBreak(flights));
    }

}