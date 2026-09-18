package com.example.kindleschneiderinventoryapp.domain;

public enum AnimalType {
    DOG, CAT, REPTILE, AMPHIBIAN, FARM, SMALL_ANIMAL, OTHER;

    @Override
    public String toString() {
        return switch(this.ordinal()) {
            case 0 -> "Dog";
            case 1 -> "Cat";
            case 2 -> "Reptile";
            case 3 -> "Amphibian";
            case 4 -> "Farm";
            case 5 -> "Small Animal";
            default -> "Other";
        };
    }

}
