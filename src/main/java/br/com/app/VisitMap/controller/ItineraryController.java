package br.com.app.VisitMap.controller;

import br.com.app.VisitMap.model.Itinerary;
import br.com.app.VisitMap.service.ItineraryService;
import br.com.app.VisitMap.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/itineraries")
public class ItineraryController {

    @Autowired
    private ItineraryService itineraryService;

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public ModelAndView listPlaylists() {
        List<Itinerary> itineraries = itineraryService.findAllItneraries();
        ModelAndView modelAndView = new ModelAndView("itinerary/list");
        modelAndView.addObject("itineraries", itineraries);
        return modelAndView;
    }
}
