package ru.byprogminer.wutugift;

import java.util.ArrayList;
import java.util.Set;

public class AbstractEvent {

    public static int counter = 0;

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
