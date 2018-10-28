package ru.byprogminer.wutugift;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashMap;

@RestController()
@RequestMapping("/")
public class EventsController {

    @RequestMapping("HUI")
    public GeneralEvent hui(@RequestParam(value = "name", defaultValue = "hui") String name) {
        return new GeneralEvent(name);
    }

    @RequestMapping("")
    public ModelAndView root() {
        HashMap <String, Object> model = new HashMap<>();
        model.put("general", GeneralEvent.GENERAL_EVENTS);
        model.put("calendar", CalendarEvent.CALENDAR_EVENTS);

        return new ModelAndView("events/index", model);
    }

    @RequestMapping("add")
    public ModelAndView add() {
        return new ModelAndView("events/add");
    }

    @PostMapping("add/submit/general")
    public RedirectView addSubmitGeneral(String name, String description) {
        GeneralEvent e = new GeneralEvent(name);
        e.description = description;

        return new RedirectView("/event/" + e.id);
    }

    @PostMapping("add/submit/calendar")
    public RedirectView addSubmitCalendar(String name, String description, int day, int month) {
        CalendarEvent e = new CalendarEvent(name, day, month);
        e.description = description;

        return new RedirectView("/event/" + e.id);
    }

    @RequestMapping("event/{id}")
    public ModelAndView event(@PathVariable("id") int id) {
        Event e = Event.EVENTS.get(id);
        HashMap <String, Object> model = new HashMap<>();
        model.put("event", e);

        return new ModelAndView("events/event", model);
    }

    @RequestMapping(value = "event/{id}/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] eventImage(@PathVariable("id") int id) {
        return new byte[0];
    }

    @RequestMapping("search")
    public ModelAndView search(@RequestParam("query") String query) {
        ArrayList <Event> events = new ArrayList<>();

        for (Event e: Event.EVENTS) {
            if (e.name.contains(query))
                events.add(e);
        }

        HashMap <String, Object> model = new HashMap<>();
        model.put("events", events);
        model.put("query", query);

        return new ModelAndView("events/search", model);
    }

    @PostMapping("gifts/add/{id}")
    public RedirectView giftsAdd(@RequestParam(value="name") String name, @PathVariable("id") int eventId) {
        Event event = Event.EVENTS.get(eventId);
        int id = event.addGift(new Gift(name, eventId));

        return new RedirectView("/event/" + eventId + "#gift" + id);
    }

    @GetMapping("gift/{id}/plus")
    public RedirectView methodGiftPlus(@PathVariable("id") int id) {
        Gift g = Gift.GIFTS.get(id);
        Event e = Event.EVENTS.get(g.eventId);
        e.gifts.remove(g);
        g.plus();
        e.gifts.add(g);

        return new RedirectView("/event/" + g.eventId + "#gift" + id);
    }

    @GetMapping("gift/{id}/minus")
    public RedirectView methodGiftMinus(@PathVariable("id") int id) {
        Gift g = Gift.GIFTS.get(id);
        Event e = Event.EVENTS.get(g.eventId);
        e.gifts.remove(g);
        g.minus();
        e.gifts.add(g);

        return new RedirectView("/event/" + g.eventId + "#gift" + id);
    }
}
