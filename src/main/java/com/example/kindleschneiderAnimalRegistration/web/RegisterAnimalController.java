package com.example.kindleschneiderAnimalRegistration.web;

import com.example.kindleschneiderAnimalRegistration.domain.Animal;
import com.example.kindleschneiderAnimalRegistration.domain.AnimalType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/register")
public class RegisterAnimalController {

    @ModelAttribute
    public void addAnimalTypesToModel(Model  model){
        model.addAttribute("AnimalType", AnimalType.values());
    }

    @GetMapping
    public String registerForm() {
        return "animalRegistrationForm";
    }
}
