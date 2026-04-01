package com.ejercicio2.vetlife2.services;

import com.ejercicio2.vetlife2.models.Pet;
import com.ejercicio2.vetlife2.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllService(){
        return this.petRepository.findAll();
    }

    public Pet getByIdService(Long id){
        return this.petRepository.findById(id);
    }

    public Pet saveService(Pet pet){
        return this.petRepository.save(pet);
    }

    public void deleteService(Long id){
        this.petRepository.delete(id);
    }

    public Pet updateService(Pet pet){
        return this.petRepository.update(pet);
    }

    public List<Map<String, Object>> findByNameService(String name){
        List<Map<String, Object>> response = new ArrayList<>();
        List<Pet> pets = this.petRepository.findByName(name);

        for (Pet pet : pets){
            Map<String, Object> petMap = new HashMap<>();
            petMap.put("Nombre: ", pet.getNombreMascota());
            petMap.put("Edad: ", pet.getEdad());
            petMap.put("Peso: ", pet.getPeso());
            petMap.put("Estado de Salud: ", pet.getEstadoSalud());
            petMap.put("Dueño: ", pet.getNombreDuenio());
            response.add(petMap);
        }
        return response;
    }




}
