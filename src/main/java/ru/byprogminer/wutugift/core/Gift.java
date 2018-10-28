package ru.byprogminer.wutugift.core;

public class Gift implements Comparable<Gift> {

    private final int id;
    private final int eventId;
    private String name;
    private String description;

    private int votes = 0;

    public Gift(int id, int eventId, String name) {
        this.id = id;
        this.eventId = eventId;
        this.name = name;
    }

    public Gift(int id, int eventId, String name, int votes) {
        this(id, eventId, name);

        this.votes = votes;
    }

    public void voteUp() {
        ++votes;
    }

    public void voteDown() {
        --votes;
    }

    public int getId() {
        return id;
    }

    public int getEventId() {
        return eventId;
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

    public int getVotes() {
        return votes;
    }

    @Override
    public int compareTo(Gift that) {
        return that.id - this.id;
    }
}