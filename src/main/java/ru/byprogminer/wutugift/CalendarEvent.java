package ru.byprogminer.wutugift;

import java.util.ArrayList;
import java.util.TreeSet;

public class CalendarEvent extends Event {

    public final static ArrayList<CalendarEvent> CALENDAR_EVENTS = new ArrayList<>();

    public final int day;
    public final int month;

    CalendarEvent(String name, int day, int month) {
        super(name);

        this.day = day;
        this.month = month;

        CALENDAR_EVENTS.add(this);
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public String toString() {
        return name + " " + day + "-" + month;
    }
}
