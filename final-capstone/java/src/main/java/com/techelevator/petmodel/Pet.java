package com.techelevator.petmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pet {
//can change to "adoptable" if we want no json stuff
    @JsonProperty("pet_id")
    private int petID;
    private String name;
    private String description;
    @JsonProperty("is_adoptable")
    private boolean isAdoptable;
    private String pic;
    private String breed;
    @JsonProperty("pet_type")
    private String type;

    public Pet() {

    }

    public Pet(int petID, String name, String description, boolean isAdoptable, String pic, String breed, String type) {
        this.petID = petID;
        this.name = name;
        this.description = description;
        this.isAdoptable = isAdoptable;
        this.pic = pic;
        this.breed = breed;
        this.type = type;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public boolean isAdoptable() {
        return isAdoptable;
    }

    public void setAdoptable(boolean adoptable) {
        isAdoptable = adoptable;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + petID +
                ", name = " + name +
                ", description = " + description +
                ", isAdoptable =" + isAdoptable +
                ", pic =" + pic +
                ", breed =" + breed +
                ", type =" + type +
                "}";
    }
}
