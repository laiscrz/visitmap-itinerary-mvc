package br.com.app.VisitMap.controller;

import br.com.app.VisitMap.model.Place;
import br.com.app.VisitMap.model.enums.TypeEntry;
import br.com.app.VisitMap.model.enums.TypePlace;
import br.com.app.VisitMap.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public ModelAndView showListPlaces() {
        List<Place> places = placeService.findAllPlaces();
        ModelAndView modelAndView = new ModelAndView("place/list");
        modelAndView.addObject("places", places);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showMusicDetails(@PathVariable Long id) {
        Place place = placeService.findByIdPlace(id);
        ModelAndView modelAndView = new ModelAndView("place/details");
        modelAndView.addObject("place", place);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView showCreatePLaceForm() {
        ModelAndView modelAndView = new ModelAndView("place/form");
        modelAndView.addObject("place", new Place());
        return modelAndView;
    }


    @PostMapping
    public String savePlace(@ModelAttribute Place place) {
        placeService.savePlace(place);
        return "redirect:/places";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deletePlace(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("place/list");
        try {
            placeService.deleteByIdPlace(id);

            modelAndView.addObject("message", "Lugar excluído com sucesso.");
        } catch (RuntimeException e) {
            modelAndView.addObject("error", e.getMessage());
        }
        modelAndView.addObject("places", placeService.findAllPlaces());
        return modelAndView;
    }

    @ModelAttribute("tipos")
    public TypePlace[] getTipos(){
        return TypePlace.values();
    }

    @ModelAttribute("entrada")
    public TypeEntry[] getEntrada(){
        return TypeEntry.values();
    }


}
