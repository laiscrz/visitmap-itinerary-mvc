package br.com.app.VisitMap.controller;

import br.com.app.VisitMap.model.Place;
import br.com.app.VisitMap.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public ModelAndView listPlaces() {
        List<Place> musics = placeService.findAllPlaces();
        ModelAndView modelAndView = new ModelAndView("place/list");
        modelAndView.addObject("places", musics);
        return modelAndView;
    }

}
