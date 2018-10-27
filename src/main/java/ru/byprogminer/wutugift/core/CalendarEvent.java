package ru.byprogminer.wutugift.core;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CalendarEvent extends Event {

    @NotNull
    private Date date;

    public CalendarEvent(long id, @NotNull String name, @NotNull Date date) {
        super(id, name);

        this.date = date;
    }

    public @NotNull Date getDate() {
        return date;
    }

    public void setDate(@NotNull Date date) {
        this.date = date;
    }
}
