package ru.byprogminer.wutugift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test {
    /*
    public static void main(String[] args) {
        Event birthday = new GeneralEvent("Birthday");
        Event christmas = new CalendarEvent("Christmas",new Date(12072000));
        Event easter = new GeneralEvent("Easter");
        birthday.addGift(new Gift("Dildo"));
        birthday.addGift(new Gift("Sex Doll"));
        for (int i = 0; i < Event.EVENTS.size(); i++) {
            System.out.println(i + ": " + Event.EVENTS.get(i));
        }
    }
    */

    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }
}
