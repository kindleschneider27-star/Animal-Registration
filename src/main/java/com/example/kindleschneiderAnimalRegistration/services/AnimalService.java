package com.example.kindleschneiderAnimalRegistration.services;

import com.example.kindleschneiderAnimalRegistration.data.AnimalRepository;
import com.example.kindleschneiderAnimalRegistration.domain.Animal;
import com.example.kindleschneiderAnimalRegistration.web.RegisterAnimalController;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalService {
    private static final Logger logger = LoggerFactory.getLogger(AnimalService.class);
    private final AnimalRepository animalRepo;

    public AnimalService(AnimalRepository ar) {
        animalRepo = ar;
    }

    @Transactional
    public Animal registerNewAnimal(Animal animal) {
        if(animal.hasImage()) {
            String imageName = animal.getImage().getImageName();
            imageName = animal.getName() + imageName.substring(imageName.lastIndexOf('.'));
            animal.getImage().setImageName(imageName);
        }

        animal = animalRepo.save(animal);
        logger.info("Animal Registered {}", animal);
        return animal;
    }

    public Optional<Animal> getAnimalbyId(UUID id) {
        return animalRepo.findById(id);
    }

    public Map<UUID, Animal> getAllAnimals() {
        Map<UUID, Animal> db = new HashMap<>();
        animalRepo.findAll().forEach(animal -> db.put(animal.getId(), animal));
        return db;
    }
}
