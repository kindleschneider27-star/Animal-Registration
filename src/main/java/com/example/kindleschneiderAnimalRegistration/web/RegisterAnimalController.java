package com.example.kindleschneiderAnimalRegistration.web;


import com.example.kindleschneiderAnimalRegistration.domain.Animal;
import com.example.kindleschneiderAnimalRegistration.domain.AnimalType;
import com.example.kindleschneiderAnimalRegistration.services.AnimalService;
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

@Controller
@RequestMapping("/register")
public class RegisterAnimalController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterAnimalController.class);

    private final AnimalService animalService;

    public RegisterAnimalController(AnimalService as) {
        animalService = as;
    }

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

       Animal addedAnimal = animalService.registerNewAnimal(animal);
        return "redirect:/view/current/" + addedAnimal.getId();
    }
}
