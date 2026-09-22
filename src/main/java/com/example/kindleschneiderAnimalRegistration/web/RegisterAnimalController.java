package com.example.kindleschneiderAnimalRegistration.web;


import com.example.kindleschneiderAnimalRegistration.domain.Animal;
import com.example.kindleschneiderAnimalRegistration.domain.AnimalDB;
import com.example.kindleschneiderAnimalRegistration.domain.AnimalType;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/register")
public class RegisterAnimalController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterAnimalController.class);

    @Autowired
    private AnimalDB animalDB;

    @ModelAttribute("pageTitle")
    public String addPageTitle(){
        return "Register Animal";
    }

    @ModelAttribute
    public void addAnimalTypesToModel(Model  model){
        model.addAttribute("AnimalType", AnimalType.values());
    }

    @ModelAttribute
    public Animal animal(){
        return new Animal();
    }


    @GetMapping
    public String registerForm() {
        return "animalRegistrationForm";
    }

    @PostMapping
    public String processAnimalRegister(@Valid Animal animal, Errors errors) {
        logger.debug("Animal registered : {}", animal);

        if(errors.hasErrors()){
            return "animalRegistrationForm";
        }

        if(animal.hasImage()) {
            String imageName = animal.getImage().getName();
            imageName = animal.getName() + imageName.substring(imageName.lastIndexOf('.'));
            animal.getImage().setName(imageName);
        }

        animalDB.addAnimal(animal);

       logger.info("Animal Registered {}", animal);

        return "redirect:/view/current/" + animal.getId();
    }
}
