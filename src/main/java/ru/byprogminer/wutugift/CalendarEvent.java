package ru.byprogminer.wutugift;

import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

public class CalendarEvent extends AbstractEvent {

    public final Date date;
    public final String name;
    public final int id;

    CalendarEvent(String name, Date date) {
        this.name = name;
        this.date = date;
        gifts = new TreeSet<Gift>();
        this.id = counter++;
    }
    public Date getDate() { return date; }
}
