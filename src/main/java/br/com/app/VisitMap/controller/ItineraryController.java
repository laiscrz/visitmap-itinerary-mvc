package br.com.app.VisitMap.controller;

import br.com.app.VisitMap.model.Itinerary;
import br.com.app.VisitMap.model.enums.TypeCountry;
import br.com.app.VisitMap.service.ItineraryService;
import br.com.app.VisitMap.service.PlaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/new")
    public ModelAndView showCreateItineraryForm() {
        ModelAndView modelAndView = new ModelAndView("itinerary/form");
        modelAndView.addObject("itinerary", new Itinerary());
        modelAndView.addObject("places", placeService.findAllPlaces());
        return modelAndView;
    }

    @PostMapping
    public String saveItinerary(@Valid @ModelAttribute Itinerary itinerary) {
        itineraryService.saveItinerary(itinerary);
        return "redirect:/itineraries";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditItineraryForm(@PathVariable Long id) {
        Itinerary itinerary = itineraryService.findByIdItinerary(id);
        ModelAndView modelAndView = new ModelAndView("itinerary/form");
        modelAndView.addObject("itinerary", itinerary);
        modelAndView.addObject("places", placeService.findAllPlaces());
        return modelAndView;
    }

    @PostMapping("/{id}")
    public String updateItinerary(@PathVariable Long id, @ModelAttribute Itinerary itinerary) {
        itinerary.setId(id);
        itineraryService.saveItinerary(itinerary);
        return "redirect:/itineraries";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteItinerary(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("itinerary/list");
        try {
            itineraryService.deleteByIdItinerary(id);
            modelAndView.addObject("message", "Itinerário excluído com sucesso.");
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
