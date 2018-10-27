package ru.byprogminer.wutugift;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.byprogminer.wutugift.core.Event;
import ru.byprogminer.wutugift.core.Gift;

import java.util.ArrayList;
import java.util.TreeSet;

@Controller
public class EventsController {

    private final ArrayList <Event> events = new ArrayList<>();
    private final ArrayList <Gift> gifts = new ArrayList<>();

    private final TreeSet <Event> generalEvents = new TreeSet<>();
    private final TreeSet <Event> calendarEvents = new TreeSet<>();

    @RequestMapping("/")
    public String index(ModelMap model) {
        model.addAttribute("general", generalEvents);
        model.addAttribute("calendar", calendarEvents);

        return "events/index";
    }
}
