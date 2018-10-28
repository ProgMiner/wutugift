package ru.byprogminer.wutugift;

import java.util.ArrayList;

public class GeneralEvent extends Event {

    public final static ArrayList<GeneralEvent> GENERAL_EVENTS = new ArrayList<>();

    public GeneralEvent(String name) {
        super(name);

        GENERAL_EVENTS.add(this);
    }

    public String toString() {
        return name;
    }
}
