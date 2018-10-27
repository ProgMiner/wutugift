package ru.byprogminer.wutugift.core;

import javax.validation.constraints.NotNull;

public class GeneralEvent extends Event {

    public GeneralEvent(long id, @NotNull String name) {
        super(id, name);
    }
}
