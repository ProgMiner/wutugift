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
    public RedirectView addSubmitGeneral(@ModelAttribute GeneralEvent event) {
        return new RedirectView("/event/" + event.id);
    }

    @PostMapping("add/submit/calendar")
    public RedirectView addSubmitCalendar(@ModelAttribute CalendarEvent event) {
        return new RedirectView("/event/" + event.id);
    }

    @RequestMapping("event/{id}")
    public Event event(@PathVariable("id") int id) {
        Event ev = Event.EVENTS.get(id);
        return ev;
    }

    @RequestMapping(value = "event/{id}/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] eventImage(@PathVariable("id") int id) {
        return new byte[0];
    }

    @RequestMapping("search")
    public ArrayList<Event> search(@RequestParam("query") String query) {
        ArrayList <Event> fits = new ArrayList<>();

        for (Event e: Event.EVENTS) {
            if (e.name.contains(query))
                fits.add(e);
        }

        return fits;
    }

    @PostMapping("method/event/{id}/gifts/add")
    public int methodEventGiftsAdd(@RequestParam(value="name") String name, @PathVariable("id") int postId) {
        Event event = Event.EVENTS.get(postId);
        int id = event.addGift(new Gift(name));
        return id;
    }

    @PostMapping("method/gift/{id}/plus")
    public void methodGiftPlus(@PathVariable("id") int id) {
        Gift g = Gift.GIFTS.get(id);
        g.plus();
    }

    @PostMapping("method/gift/{id}/minus")
    public void methodGiftMinus(@PathVariable("id") int id) {
        Gift g = Gift.GIFTS.get(id);
        g.minus();
    }
}
