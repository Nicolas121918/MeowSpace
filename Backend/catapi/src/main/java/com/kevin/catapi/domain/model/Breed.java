package com.kevin.catapi.domain.model;

public class Breed {
    private String id;
    private String name;
    private String origin;
    private String description;


    public Breed() {}

    public Breed(String id, String name, String origin, String description){
        this.id = id;
        this.name = name;
        this.origin = origin ; 
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
