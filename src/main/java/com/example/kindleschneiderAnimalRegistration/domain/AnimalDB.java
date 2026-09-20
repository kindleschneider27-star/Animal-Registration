package com.example.kindleschneiderAnimalRegistration.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Scope("singleton")
public class AnimalDB {
    private Map <UUID, Animal> animals = new HashMap<>();

    public Map <UUID, Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal){
        animals.put(animal.getId(), animal);

    }
}
