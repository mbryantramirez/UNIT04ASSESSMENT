package com.example.unit_04_assessment;

public class Message {
    private String animal;
    private String image;
    private String wiki;

    public Message(String animal, String image, String wiki) {
        this.animal = animal;
        this.image = image;
        this.wiki = wiki;
    }

    public String getAnimal() {
        return animal;
    }

    public String getImage() {
        return image;
    }

    public String getWiki() {
        return wiki;
    }
}
