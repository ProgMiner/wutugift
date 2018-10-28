package ru.byprogminer.wutugift;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Event {

    public final static ArrayList <Event> EVENTS = new ArrayList<>();
    public static int counter = 0;

    public final int id;
    public String name;
    public String description;
    public BufferedImage image;
    public NavigableSet <Gift> gifts = new TreeSet<>();

    public Event(String name) {
        id = counter++;
        this.name = name;
        EVENTS.add(this);
    }

    public String getName() { return name; }
    //public Set getGifts() { return gifts; }
    public int addGift(Gift g) {
        gifts.add(g);
        return g.id;
    }
    public void removeGift(int id) { gifts.remove(Gift.GIFTS.get(id)); }

}