package ru.byprogminer.wutugift;

import java.util.TreeSet;

public class GeneralEvent extends Event {

    // public final String name;
    // public final int id; // ???

    GeneralEvent(String name) {
        this.name = name;
        gifts = new TreeSet<Gift>();
        this.id = counter++;
        EVENTS.add(this.id, this);
    }
    public String toString() {
        return name;
    }


}
