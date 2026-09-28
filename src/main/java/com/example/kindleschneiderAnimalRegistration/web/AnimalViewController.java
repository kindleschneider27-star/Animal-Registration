package com.example.kindleschneiderAnimalRegistration.web;

import com.example.kindleschneiderAnimalRegistration.services.AnimalService;
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

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/view")
public class AnimalViewController {
    private static final Logger logger = LoggerFactory.getLogger(AnimalViewController.class);

private final AnimalService animalService;

public AnimalViewController(AnimalService as) {
    animalService = as;

}

    @GetMapping("/current/{id}")
    public String viewAnimal(@PathVariable UUID id, Model model) {

        Optional<Animal> animal = animalService.getAnimalbyId(id);
        if(animal.isEmpty()){
            logger.debug("No animal found with id: {} ", id);
            return "redirect:/list";
        }

        Animal current = animal.get();
        model.addAttribute("current", current);
        model.addAttribute("pageTitle", current.getName());
        return "viewAnimal";
    }
}
