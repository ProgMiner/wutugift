package ru.byprogminer.wutugift.core;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Gift {

    private final long id;
    @NotNull
    private String name;

    private int votes = 0;
    @NotNull
    private Date date = new Date();
    private double hotCoef = 0D;

    public Gift(long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public Gift(long id, @NotNull String name, int votes, @NotNull Date date, double hotCoef) {
        this(id, name);

        this.votes = votes;
        this.date = date;
        this.hotCoef = hotCoef;
    }

    public void voteUp() {
        ++votes;
        hotCoef += System.currentTimeMillis() - date.getTime();
    }

    public void voteDown() {
        --votes;
        hotCoef -= System.currentTimeMillis() - date.getTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public Date getDate() {
        return date;
    }

    public double getHotCoef() {
        return hotCoef;
    }
}