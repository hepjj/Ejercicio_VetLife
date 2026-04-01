package com.ejercicio2.vetlife2.repositories;


import com.ejercicio2.vetlife2.models.Pet;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.ArrayList;

@Repository
public class PetRepository {

    public List<Pet> petList = new ArrayList<>();

    public List<Pet> findAll(){
        return this.petList;
    }

    public Pet findById(Long id){
        for (Pet pet : this.petList){
            if (id == pet.getId()){
                return pet;
            }
        }
        return null;
    }

    public Pet save (Pet newPet){
        Pet petFindID = this.findById (newPet.getId());
        if (petFindID == null){
            this.petList.add(newPet);
        }else{
            throw new RuntimeException("Pet with ID "+newPet.getId()+" already exists");
        }
        return null;
    }

    public void delete (Long id){
        Pet pet = this.findById(id);
        this.petList.remove(id);
    }
    public Pet update(Pet updatedPet){
        int position = 0;
        boolean find = false;
        for(int i=0; i<this.petList.size(); i++){
            if(this.petList.get(i).equals(updatedPet.getId())){
                position = i;
                find = true;
                break;
            }
        }
        if(find){
            this.petList.set(position, updatedPet);
            return updatedPet;
        }else{
            throw new RuntimeException("Pet with ID "+updatedPet.getId()+" does not exists");
        }
    }

    public List<Pet> findByName(String name){
        List<Pet> pets = new ArrayList<>();
        for (Pet pet : this.petList){
            if(pet.getNombreMascota().equals(name)){
                pets.add(pet);
            }
        }
        return pets;
    }
}

