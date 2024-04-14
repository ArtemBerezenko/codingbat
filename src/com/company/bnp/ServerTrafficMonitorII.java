package com.company.bnp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Server Traffic Monitor
//There is client-server architecture with n clients and one server.
// Each client starts its interaction with the server at the second start[i] and stops at the second end[i].
// The maximum traffic is defined as the maximum number of concurrent interactions with the server.
//
//Find the earliest time at which the maximum number of clients are interacting with the server.
//
//Note: The endpoint is also included in the interaction.
//
//Example
//Suppose start = [1, 6, 2, 9] and end = [8, 7, 6, 10]
//
//The maximum number of concurrent interactions is 3 which happens first at the 6th second. Return 6.
//
//Function Description
//Complete the function getMaxTrafficTime in the editor below.
//
//getMaxTrafficTime has the following parameters:
//int start[n]: interaction start times
//int end[n]: interaction end times
//
//Returns
//int: the earliest time of maximum concurrent interactions
//
//Constraints
//1 ≤ n ≤ 10^5
//1 ≤ start[i] ≤ end[i] ≤ 10^9

//is a common competitive programming problem often related to the "sweep line" technique or handling interval overlaps,
//which is useful in many scenarios including meeting rooms, bandwidth management, and event scheduling.

public class ServerTrafficMonitorII {
    private static class Event {
        int time;
        boolean isStart;

        public Event(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        public int getTime() {
            return time;
        }

        public boolean isStart() {
            return isStart;
        }
    }
    
    public static int getMaxTrafficTime(List<Integer> start, List<Integer> end) {
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < start.size(); i++) {
            events.add(new Event(start.get(i), true));
            events.add(new Event(end.get(i) + 1, false));
        }

        events.sort(Comparator.comparing(Event::getTime).thenComparing(Event::isStart));

        int maxTraffic = 0;
        int currentTraffic = 0;
        int earliestTime = 0;

        for (Event event : events) {
            if (event.isStart) {
                currentTraffic++;
                if (currentTraffic > maxTraffic) {
                    maxTraffic = currentTraffic;
                    earliestTime = event.time;
                }
            } else {
                currentTraffic--;
            }
        }

        return earliestTime;
    }

    public static void main(String[] args) {
        System.out.println(getMaxTrafficTime(List.of(1,6,2,9), List.of(8,7,6,10)));
    }
}
