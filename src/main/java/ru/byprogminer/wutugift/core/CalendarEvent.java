package ru.byprogminer.wutugift.core;

import ru.byprogminer.wutugift.util.Date;

public class CalendarEvent extends Event {

    private Date date;

    public CalendarEvent(int id, String name, Date date) {
        super(id, name);

        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
