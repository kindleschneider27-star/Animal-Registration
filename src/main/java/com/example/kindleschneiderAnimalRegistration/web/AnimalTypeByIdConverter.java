package com.example.kindleschneiderAnimalRegistration.web;

import com.example.kindleschneiderAnimalRegistration.domain.Animal;
import com.example.kindleschneiderAnimalRegistration.domain.AnimalType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnimalTypeByIdConverter implements Converter<String, AnimalType> {


    @Override
    public AnimalType convert(String source) {
        if (source.equals("Small Animal")){
            return AnimalType.SMALL_ANIMAL;
        }
        return AnimalType.valueOf(source.toUpperCase());
    }
}
