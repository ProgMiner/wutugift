package ru.byprogminer.wutugift;

import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

public class CalendarEvent extends AbstractEvent {

    public final int day;
    public final int month;
    public final String name;
    public final int id;

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
        return name + " " + day + "/" + month;
    }
}
