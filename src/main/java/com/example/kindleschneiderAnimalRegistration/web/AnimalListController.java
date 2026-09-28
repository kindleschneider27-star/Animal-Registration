package com.example.kindleschneiderAnimalRegistration.web;


import com.example.kindleschneiderAnimalRegistration.domain.AnimalDB;
import com.example.kindleschneiderAnimalRegistration.services.AnimalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class AnimalListController {
    private static final Logger logger = LoggerFactory.getLogger(AnimalViewController.class);
    private final AnimalService animalService;

    public AnimalListController(AnimalService as) {
        animalService = as;
    }



    @ModelAttribute("pageTitle")
    public String addPageTitle(){
        return "List Animals";
    }

    @GetMapping
    public String listAnimals(Model model) {
        model.addAttribute("animal", animalService.getAllAnimals());
        return "listAnimals";
    }
}
