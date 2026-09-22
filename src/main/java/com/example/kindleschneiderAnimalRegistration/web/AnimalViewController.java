package com.example.kindleschneiderAnimalRegistration.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import com.example.kindleschneiderAnimalRegistration.domain.Animal;
import com.example.kindleschneiderAnimalRegistration.domain.AnimalDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/view")
public class AnimalViewController {
    private static final Logger logger = LoggerFactory.getLogger(AnimalViewController.class);

    @Autowired
    private AnimalDB animalDB;

    @GetMapping("/current/{id}")
    public String viewAnimal(@PathVariable UUID id, Model model) {

        Animal current = animalDB.getAnimals().get(id);
        if(current == null){
            logger.debug("No animal found with id: {} ", id);
            return "redirect:/list";
        }
        model.addAttribute("current", current);
        model.addAttribute("pageTitle", current.getName());
        return "viewAnimal";
    }
}
