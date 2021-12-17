package com.techelevator.petdao;

import com.techelevator.petmodel.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetDao implements PetDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Pet pet = mapRowToPet(results);
            pets.add(pet);
        }
        return pets;
    }
    //this method is for adding a new pet
    @Override
    public Pet getPetById(int newId) {
        String sql = "SELECT pet_id, name, description, is_adoptable, pic, breed, pet_type " +
                " FROM pets" +
                " WHERE pet_id = ?;";
        Pet pet = null;
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, newId);
        if (results.next()){
            pet = mapRowToPet(results);
        }
        return pet;
    }
    //this method is for updating a pet
    @Override
    public Pet getPetWithId(int petid) {
        String sql = "SELECT pet_id, name, description, is_adoptable, pic, breed, pet_type " +
                " FROM pets" +
                " WHERE pet_id = ?;";
        Pet pet = null;
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, petid);
        if (results.next()){
            pet = mapRowToPet(results);
        }
        return pet;
    }

    @Override
    public Pet addPetListing(Pet newPet) {
        String sql = "INSERT INTO pets (name, description, is_adoptable, pic, breed, pet_type)" +
                " VALUES(?,?,?,?,?,?) RETURNING pet_id;";
        Integer petId = jdbcTemplate.queryForObject(sql, Integer.class, newPet.getName(), newPet.getDescription(), newPet.isAdoptable(),
                newPet.getPic(), newPet.getBreed(), newPet.getType());
        return getPetById(petId);
    }

    @Override
    public void updatePetListing(Pet pet) {
        String sql = ("UPDATE pets SET name = ?, description = ?, is_adoptable = ?, pic = ?, breed = ?, pet_type = ? " +
                "WHERE pet_id = ?");
        jdbcTemplate.update(sql, pet.getName(), pet.getDescription(), pet.isAdoptable(), pet.getPic(), pet.getBreed(), pet.getType(), pet.getPetID());
    }

    private Pet mapRowToPet(SqlRowSet results) {
        Pet pet = new Pet();
        pet.setPetID(results.getInt("pet_id"));
        pet.setName(results.getString("name"));
        pet.setDescription(results.getString("description"));
        pet.setAdoptable(results.getBoolean("is_adoptable"));
        pet.setPic(results.getString("pic"));
        pet.setBreed(results.getString("breed"));
        pet.setType(results.getString("pet_type"));
        return pet;
    }

}
