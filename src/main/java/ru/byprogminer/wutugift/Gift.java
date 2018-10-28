package ru.byprogminer.wutugift;

import java.util.ArrayList;

public class Gift implements Comparable<Gift> {

    public static ArrayList <Gift> GIFTS = new ArrayList<Gift>();
    public static int counter;

    public String name;
    public String description;
    int rating;
    public final int eventId;
    public final int id;

    public Gift(String name, int eventId) {
        this.id = counter++;
        this.eventId = eventId;
        this.name = name;
        GIFTS.add(this.id, this);
    }

    public String getName() { return name; }
    public int getRating() { return rating; }
    public void plus() { rating++; }
    public void minus() { rating--; }
    public String toString() { return name+" "+rating; }

    public int compareTo(Gift that) {
        if (this.rating == that.rating) {
            return that.id - this.id;
        }

        return that.rating - this.rating;
    }
}
