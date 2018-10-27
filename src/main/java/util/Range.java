package util;

public class Range {

    public final int begin;
    public final int end;

    public Range(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public int length() {
        return end - begin;
    }
}
