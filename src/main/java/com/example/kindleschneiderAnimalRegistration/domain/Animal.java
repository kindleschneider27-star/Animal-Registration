package com.example.kindleschneiderAnimalRegistration.domain;

import java.util.UUID;

public class Animal {
    private UUID id = UUID.randomUUID();
    private String name;
    private AnimalType type;
    private String subtype;
    private String birthdate;
    private String ownerName;
    private String ownerContact;
    private Image image;

    public Animal(UUID id, String name, AnimalType type, String subtype, String birthdate, String ownerName, String ownerContact, Image image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.subtype = subtype;
        this.birthdate = birthdate;
        this.ownerName = ownerName;
        this.ownerContact = ownerContact;
        this.image = image;
    }

    public Animal() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean hasImage() {
        return image != null && image.getContents().length > 0;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", subtype='" + subtype + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerContact='" + ownerContact + '\'' +
                ", image=" + image +
                '}';
    }
}
