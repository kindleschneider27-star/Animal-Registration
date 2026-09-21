package com.example.kindleschneiderAnimalRegistration.web;


import com.example.kindleschneiderAnimalRegistration.domain.Animal;
import com.example.kindleschneiderAnimalRegistration.domain.AnimalDB;
import com.example.kindleschneiderAnimalRegistration.domain.AnimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/register")
public class RegisterAnimalController {
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
    public String processAnimalRegister(Animal animal){

        if(animal.hasImage()) {
            String imageName = animal.getImage().getName();
            imageName = animal.getName() + imageName.substring(imageName.lastIndexOf('.'));
            animal.getImage().setName(imageName);
        }

        animalDB.addAnimal(animal);

        //test
        System.out.println(animal);

        return "redirect:/view/current/" + animal.getId();
    }
}
