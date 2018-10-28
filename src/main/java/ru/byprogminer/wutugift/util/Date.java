package ru.byprogminer.wutugift.util;

import java.time.Month;

public class Date implements Comparable <Date> {

    public final int day;
    public final Month month;

    public Date(int day, Month month) {
        this.day = day;
        this.month = month;
    }

    @Override
    public int compareTo(Date that) {
        if (this.month == that.month) {
            return that.day - this.day;
        }

        return that.month.compareTo(this.month);
    }
}
