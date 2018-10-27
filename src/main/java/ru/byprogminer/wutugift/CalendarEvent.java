package ru.byprogminer.wutugift;

import java.util.TreeSet;

public class CalendarEvent extends Event {

    public final int day;
    public final int month;

    CalendarEvent(String name, int day, int month) {
        this.name = name;
        this.day = day;
        this.month = month;
        gifts = new TreeSet<Gift>();
        this.id = counter++;
        EVENTS.add(this.id, this);
    }
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public String toString() {
        return name + " " + day + "-" + month;
    }
}
