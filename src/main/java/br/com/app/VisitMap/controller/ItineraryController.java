package br.com.app.VisitMap.controller;

import br.com.app.VisitMap.model.Itinerary;
import br.com.app.VisitMap.model.enums.TypeCountry;
import br.com.app.VisitMap.model.enums.TypeEntry;
import br.com.app.VisitMap.service.ItineraryService;
import br.com.app.VisitMap.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ModelAndView listItineraries() {
        List<Itinerary> itineraries = itineraryService.findAllItneraries();
        ModelAndView modelAndView = new ModelAndView("itinerary/list");
        modelAndView.addObject("itineraries", itineraries);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showItineraryDetails(@PathVariable Long id) {
        Itinerary itinerary = itineraryService.findByIdItinerary(id);
        ModelAndView modelAndView = new ModelAndView("itinerary/details");
        modelAndView.addObject("itinerary", itinerary);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteItinerary(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("itinerary/list");
        try {
            itineraryService.deleteByIdItinerary(id);
            modelAndView.addObject("message", "Playlist excluída com sucesso.");
        } catch (RuntimeException e) {
            modelAndView.addObject("error", e.getMessage());
        }
        modelAndView.addObject("itineraries", itineraryService.findAllItneraries());
        return modelAndView;
    }

    @ModelAttribute("pais")
    public TypeCountry[] getPais(){
        return TypeCountry.values();
    }
}
