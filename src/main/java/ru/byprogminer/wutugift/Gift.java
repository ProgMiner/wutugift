package ru.byprogminer.wutugift;

import java.util.ArrayList;

public class Gift {

    public static ArrayList GIFTS = new ArrayList<Gift>();
    public static int counter;

    public String name;
    int rating;
    public final int id;

    public Gift(String name) {
        this.name = name;
        this.id = counter++;
        GIFTS.add(this.id, this);
    }

    public String getName() { return name; }
    public int getRating() { return rating; }
    public void plus() { rating++; }
    public void minus() { rating--; }
    public String toString() { return name+" "+rating; }

}
