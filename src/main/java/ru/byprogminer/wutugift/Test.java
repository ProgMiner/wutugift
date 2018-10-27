package ru.byprogminer.wutugift;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.byprogminer.wutugift.AbstractEvent;
import ru.byprogminer.wutugift.GeneralEvent;

import java.util.Date;
import java.util.Set;

@SpringBootApplication
public class Test {
    /*
    public static void main(String[] args) {
        AbstractEvent birthday = new GeneralEvent("Birthday");
        AbstractEvent christmas = new CalendarEvent("Christmas",new Date(12072000));
        AbstractEvent easter = new GeneralEvent("Easter");
        birthday.addGift(new Gift("Dildo"));
        birthday.addGift(new Gift("Sex Doll"));
        for (int i = 0; i < AbstractEvent.EVENTS.size(); i++) {
            System.out.println(i + ": " + AbstractEvent.EVENTS.get(i));
        }
    }
    */

    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }
}
