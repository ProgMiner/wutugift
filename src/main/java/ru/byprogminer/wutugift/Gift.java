package ru.byprogminer.wutugift;

import java.util.ArrayList;

public class Gift implements Comparable<Gift> {

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

    public int compareTo(Gift that) {
        if (this.getRating()<that.getRating()) return -1;
        if (this.getRating()==that.getRating()) return 0;
        return 1;
    }

}
