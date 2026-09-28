package com.example.kindleschneiderAnimalRegistration.web;


import com.example.kindleschneiderAnimalRegistration.domain.AnimalDB;
import com.example.kindleschneiderAnimalRegistration.domain.AnimalType;
import com.example.kindleschneiderAnimalRegistration.services.AnimalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/list")
public class AnimalListController {
    private static final Logger logger = LoggerFactory.getLogger(AnimalListController.class);
    private final AnimalService animalService;

    public AnimalListController(AnimalService as) {
        animalService = as;
    }

    @ModelAttribute("pageTitle")
    public String addPageTitle(){
        return "List Animals";
    }

    @ModelAttribute
    public void addAnimalTypeToModel(Model model){
        model.addAttribute("AnimalType", AnimalType.values());
    }

    @GetMapping
    public String listAnimals(@RequestParam(defaultValue = "") String searchName,
                              @RequestParam(required = false) AnimalType filterType,
                              @RequestParam(defaultValue = "") String filterSubtype,
                              Model model) {
        model.addAttribute("animalDB", animalService.searchAnimals(searchName, filterType, filterSubtype));

        model.addAttribute("searchName", searchName);
        model.addAttribute("filterType", filterType);
        model.addAttribute("filterSubtype", filterSubtype);
        return "listAnimals";
    }
}
