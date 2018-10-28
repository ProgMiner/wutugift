package ru.byprogminer.wutugift.core;

import java.util.TreeSet;

public abstract class Event implements Comparable <Event> {

    public enum GiftSort {
        RATING, DATING
    }

    private final int id;
    private String name;
    private String description;
    private long views = 0;

    private final TreeSet <Gift> ratingGifts = new TreeSet<>();
    private final TreeSet <Gift> datingGifts = new TreeSet<>();

    public Event(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Gift[] getGifts() {
        return getGifts(GiftSort.RATING);
    }

    public Gift[] getGifts(GiftSort sorting) {
        TreeSet <Gift> gifts;

        switch (sorting) {
            case RATING:
                gifts = ratingGifts;
                break;
            case DATING:
                gifts = datingGifts;
                break;
            default:
                return new Gift[0];
        }

        Gift[] ret = new Gift[gifts.size()];
        int index = 0;
        for (Gift gift: gifts) {
            ret[index++] = gift;
        }

        return ret;
    }

    public void addGift(Gift gift) {
        ratingGifts.add(gift);
        datingGifts.add(gift);
    }

    public void refreshGift(Gift gift) {
        ratingGifts.remove(gift);
        ratingGifts.add(gift);
    }

    public void removeGift(Gift gift) {
        ratingGifts.remove(gift);
        datingGifts.remove(gift);
    }

    public void addView() {
        ++views;
    }

    @Override
    public int compareTo(Event that) {
        if (this.views == that.views) {
            return that.id - this.id;
        }

        return (that.views - this.views) > 0 ? 1 : -1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getViews() {
        return views;
    }
}
