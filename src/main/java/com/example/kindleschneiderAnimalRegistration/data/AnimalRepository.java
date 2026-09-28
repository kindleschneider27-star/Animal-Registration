package com.example.kindleschneiderAnimalRegistration.data;


import com.example.kindleschneiderAnimalRegistration.domain.Animal;
import com.example.kindleschneiderAnimalRegistration.domain.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnimalRepository extends JpaRepository<Animal, UUID> {
    List<Animal> findByNameContainingIgnoreCase(String name);
    List<Animal> findByType(AnimalType type);
    List<Animal> findBySubtypeContainingIgnoreCase(String subtype);
    List<Animal> findByNameContainingIgnoreCaseAndType(String name, AnimalType type);
    List<Animal> findByNameContainingIgnoreCaseAndSubtypeContainingIgnoreCase(String name, String subtype);
    List<Animal> findByTypeAndSubtypeContainingIgnoreCase(AnimalType type, String subtype);
    List<Animal> findByNameContainingIgnoreCaseAndTypeAndSubtypeContainingIgnoreCase(String name, AnimalType type, String subtype);



}
