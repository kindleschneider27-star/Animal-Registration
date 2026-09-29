package com.example.kindleschneiderAnimalRegistration.web;

import com.example.kindleschneiderAnimalRegistration.domain.AnimalType;
import com.example.kindleschneiderAnimalRegistration.services.AnimalService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import com.example.kindleschneiderAnimalRegistration.domain.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
            logger.debug("No animal found with id: {} to view", id);
            return "redirect:/list";
        }

        Animal current = animal.get();
        model.addAttribute("current", current);
        model.addAttribute("pageTitle", current.getName());
        return "viewAnimal";
    }

    @GetMapping("/current/{id}/edit")
    public String viewEditAnimal(@PathVariable UUID id, Model model) {

        Optional<Animal> animal = animalService.getAnimalbyId(id);
        if(animal.isEmpty()){
            logger.debug("No animal found with id: {} to edit", id);
            return "redirect:/list";
        }

        Animal current = animal.get();

        model.addAttribute("AnimalType", AnimalType.values());
        model.addAttribute("animal", current);
        model.addAttribute("pageTitle", current.getName());

    return "animalModifyForm";
    }

    @PostMapping("/current/{id}/edit")
    public String modifyAnimal(@PathVariable UUID id, @Valid Animal animal, Errors errors, Model model) {
        logger.debug("Animal registered : {} for modifying", animal);

        if(errors.hasErrors()){
            model.addAttribute("AnimalType", AnimalType.values());
            model.addAttribute("pageTitle", animal.getName());
            return "animalModifyForm";
        }

        animalService.updateAnimal(id, animal);
        return "redirect:/view/current/" + id;
    }

    @PostMapping("/current/{id}/delete")
    public String deleteAnimal(@PathVariable UUID id) {

    animalService.deleteAnimalById(id);
        return "redirect:/list";
    }

}
