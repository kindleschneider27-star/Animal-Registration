package com.example.kindleschneiderAnimalRegistration.web;


import com.example.kindleschneiderAnimalRegistration.domain.AnimalDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class AnimalListController {

    @Autowired
    private AnimalDB animalDB;

    @ModelAttribute("pageTitle")
    public String addPageTitle(){
        return "List Animals";
    }

    @GetMapping
    public String listAnimals(Model model) {
        model.addAttribute("animals", animalDB.getAnimals());
        return "listAnimals";
    }
}
