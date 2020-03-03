package java;

import java.time.LocalDateTime;
// import java.util.TreeSet;
// import java.util.Arrays;
// import java.util.ArrayList;
import java.util.*;

public class ComparableExample {
    public static void main(String[] args) {
        Event thanksgiving = new Event("Thanksgiving", LocalDateTime.of(2019, 11, 28, 12, 0));
        Event newYears = new Event("New Years", LocalDateTime.of(2019, 1, 1, 0, 0));
        Event christmas = new Event("Christmas", LocalDateTime.of(2019, 12, 25, 10, 0));
        List<Event> events = Arrays.asList(thanksgiving, newYears, christmas);
        // sorted set
        TreeSet<Event> holidaysSet = new TreeSet<Event>(events);
        // list
        ArrayList<Event> eventList = new ArrayList<Event>(events);
        // sort list
        Collections.sort(eventList);

        System.out.println("holidaysSet: " + Arrays.toString(holidaysSet.toArray()));
        System.out.println("eventList: " + Arrays.toString(eventList.toArray()));
    }
}

class Event implements Comparable<Event> {
    String name;
    LocalDateTime date;

    public Event(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public int compareTo(Event event) {
        return this.date.compareTo(event.date);
    }

    @Override
    public String toString() {
        return name + ": " + date;
    }
}