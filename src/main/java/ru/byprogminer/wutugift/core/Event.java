package ru.byprogminer.wutugift.core;

import util.Range;

import javax.validation.constraints.NotNull;
import java.util.TreeSet;

public abstract class Event {

    public enum GiftSort {
        RATING, DATING, HOT
    }

    private final long id;
    @NotNull
    private String name;

    private final @NotNull TreeSet <Gift> ratingGifts = new TreeSet<>();
    private final @NotNull TreeSet <Gift> datingGifts = new TreeSet<>();
    private final @NotNull TreeSet <Gift> hotGifts = new TreeSet<>();

    public Event(long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public @NotNull Gift[] getGifts(@NotNull Range range) {
        return getGifts(range, GiftSort.RATING);
    }

    public @NotNull Gift[] getGifts(@NotNull Range range, @NotNull GiftSort sorting) {
        TreeSet <Gift> gifts;

        switch (sorting) {
            case RATING:
                gifts = ratingGifts;
                break;
            case DATING:
                gifts = datingGifts;
                break;
            case HOT:
                gifts = hotGifts;
                break;
            default:
                return new Gift[0];
        }

        Gift[] ret = new Gift[range.length()];
        int index = -range.begin;
        for (Gift gift: gifts) {
            ++index;

            if (index < 0) {
                continue;
            }

            ret[index] = gift;
        }

        return ret;
    }

    public void addGift(@NotNull Gift gift) {
        ratingGifts.add(gift);
        datingGifts.add(gift);
        hotGifts.add(gift);
    }

    public void removeGift(@NotNull Gift gift) {
        ratingGifts.remove(gift);
        datingGifts.remove(gift);
        hotGifts.remove(gift);
    }

    public long getId() {
        return id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
