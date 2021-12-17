package com.techelevator.petdao;

import com.techelevator.petmodel.Pet;

import java.util.List;

public interface PetDAO {

    List<Pet> getAllPets();

    public Pet addPetListing(Pet newPet);

    public Pet getPetById(int newId);

    public void updatePetListing(Pet pet);

    public Pet getPetWithId(int petid);
}

