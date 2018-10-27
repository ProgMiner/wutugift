package ru.byprogminer.wutugift;

import java.util.HashSet;
import java.util.TreeSet;

public class GeneralEvent extends AbstractEvent {

    public final String name;
    public final int id;

    GeneralEvent(String name) {
        this.name = name;
        gifts = new TreeSet<Gift>();
        this.id = counter++;
    }


}
