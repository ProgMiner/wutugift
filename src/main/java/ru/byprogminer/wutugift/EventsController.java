package ru.byprogminer.wutugift;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;


@RestController()
public class EventsController {
    //private static GeneralEvent hui = new GeneralEvent("hui");
    //private static String h = hui.toString();

    @RequestMapping("/HUI")
    public GeneralEvent huihui(@RequestParam(value="name",defaultValue = "hui") String name) {
        return new GeneralEvent(name);
    }
    @RequestMapping("/events/add") // todo add redirect
    public int addEvent(@RequestParam(value="name") String name, @RequestParam(value="ddmm", defaultValue = "0000") String ddmm) { // dateString is "DDMM"
        if (ddmm.equals("0000")) {
            GeneralEvent ge = new GeneralEvent(name);
            return ge.id;
        }
        int day = Integer.parseInt(ddmm.substring(0,2));
        int month = Integer.parseInt(ddmm.substring(2));
        CalendarEvent ce = new CalendarEvent(name,day,month);
        return ce.id;
    }

    @RequestMapping("/gifts/add")
    public int addGift(@RequestParam(value="name") String name, @RequestParam(value="id") int id) {
        AbstractEvent event = (AbstractEvent)AbstractEvent.EVENTS.get(id);
        id = event.addGift(new Gift("name"));
        return id;
    }

    @RequestMapping("/gifts/upvote")
    public void upvote(@RequestParam(value = "id") int id) {
        Gift g = (Gift) Gift.GIFTS.get(id);
        g.plus();
    }

   // @RequestMapping("events/view")
    //public


    //
}
