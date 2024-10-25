package br.com.app.VisitMap.controller;

import br.com.app.VisitMap.model.Place;
import br.com.app.VisitMap.model.enums.TypeEntry;
import br.com.app.VisitMap.model.enums.TypePlace;
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
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public ModelAndView showListPlaces() {
        List<Place> musics = placeService.findAllPlaces();
        ModelAndView modelAndView = new ModelAndView("place/list");
        modelAndView.addObject("places", musics);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showMusicDetails(@PathVariable Long id) {
        Place music = placeService.findByIdPlace(id);
        ModelAndView modelAndView = new ModelAndView("place/details");
        modelAndView.addObject("place", music);
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
