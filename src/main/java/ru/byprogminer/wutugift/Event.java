package ru.byprogminer.wutugift;

import java.util.ArrayList;
import java.util.Set;

public class Event {

    public static int counter = 0;
    public static ArrayList <Event> EVENTS = new ArrayList<Event>();

    public String name;
    public Set gifts;
    public int id;


    public String getName() { return name; }
    //public Set getGifts() { return gifts; }
    public int addGift(Gift g) {
        gifts.add(g);
        return g.id;
    }
    public void removeGift(int id) { gifts.remove(id); }

}