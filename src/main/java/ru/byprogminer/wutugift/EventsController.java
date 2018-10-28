package ru.byprogminer.wutugift;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.byprogminer.wutugift.core.CalendarEvent;
import ru.byprogminer.wutugift.core.Event;
import ru.byprogminer.wutugift.core.GeneralEvent;
import ru.byprogminer.wutugift.core.Gift;
import ru.byprogminer.wutugift.util.Date;

import java.time.Month;
import java.util.ArrayList;
import java.util.TreeSet;

@Controller
@RequestMapping("/")
public class EventsController {

    private final ArrayList<Event> events = new ArrayList<>();
    private final ArrayList<Gift> gifts = new ArrayList<>();

    private final TreeSet<GeneralEvent> generalEvents = new TreeSet<>();
    private final TreeSet<CalendarEvent> calendarEvents = new TreeSet<>((a, b) -> {
        int datesComparing = a.getDate().compareTo(b.getDate());

        if (datesComparing != 0) {
            return datesComparing;
        }

        return a.compareTo(b);
    });

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("general", generalEvents);
        model.addAttribute("calendar", calendarEvents);

        return "events/index";
    }

    // @RequestMapping("HUI")
    // public GeneralEvent hui(@RequestParam(value = "name", defaultValue = "hui") String name) {
    //     return new GeneralEvent(name);
    // }

    @RequestMapping("add")
    public String add() {
        return "events/add";
    }

    @PostMapping("add/submit/general")
    public RedirectView addSubmitGeneral(String name, String description) {
        GeneralEvent e = new GeneralEvent(events.size(), name);
        e.setDescription(description);
        generalEvents.add(e);
        events.add(e);

        return new RedirectView("/event/" + e.getId());
    }

    @PostMapping("add/submit/calendar")
    public RedirectView addSubmitCalendar(String name, String description, int day, int month) {
        CalendarEvent e = new CalendarEvent(events.size(), name, new Date(day, Month.of(month)));
        e.setDescription(description);
        calendarEvents.add(e);
        events.add(e);

        return new RedirectView("/event/" + e.getId());
    }

    @RequestMapping("event/{id}")
    public String event(@PathVariable("id") int id, @RequestParam(value = "sorting", defaultValue = "0") int sorting, Model model) {
        Event e = events.get(id);
        e.addView();

        model.addAttribute("event", e);
        model.addAttribute("sorting", Event.GiftSort.values()[sorting]);

        return "events/event";
    }

    // @RequestMapping(value = "event/{id}/image", produces = MediaType.IMAGE_PNG_VALUE)
    // public byte[] eventImage(@PathVariable("id") int id) {
    //     return new byte[0];
    // }

    @RequestMapping("search")
    public String search(@RequestParam("query") String query, Model model) {
        ArrayList<Event> events = new ArrayList<>();

        query = query.toLowerCase();
        for (Event e : this.events) {
            if (e.getName().toLowerCase().contains(query) || e.getDescription().toLowerCase().contains(query)) {
                events.add(e);
            }
        }

        model.addAttribute("events", events);
        model.addAttribute("query", query);

        return "events/search";
    }

    @PostMapping("gifts/add/{id}")
    public RedirectView giftsAdd(@RequestParam(value = "name") String name, @PathVariable("id") int eventId) {
        int id = gifts.size();

        Gift gift = new Gift(id, eventId, name, eventId);
        gifts.add(gift);

        Event event = events.get(eventId);
        event.addGift(gift);

        return new RedirectView("/event/" + eventId + "#gift" + id);
    }

    @GetMapping("gift/{id}/plus")
    public RedirectView methodGiftPlus(@PathVariable("id") int id) {
        Gift g = gifts.get(id);
        g.voteUp();

        Event e = events.get(g.getEventId());
        e.refreshGift(g);

        return new RedirectView("/event/" + g.getEventId() + "#gift" + id);
    }

    @GetMapping("gift/{id}/minus")
    public RedirectView methodGiftMinus(@PathVariable("id") int id) {
        Gift g = gifts.get(id);
        g.voteDown();

        Event e = events.get(g.getEventId());
        e.refreshGift(g);

        return new RedirectView("/event/" + g.getEventId() + "#gift" + id);
    }
}


