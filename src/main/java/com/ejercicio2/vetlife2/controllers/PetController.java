package com.ejercicio2.vetlife2.controllers;


import com.ejercicio2.vetlife2.models.Pet;
import com.ejercicio2.vetlife2.services.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/pets")
@Validated
public class PetController {
    private PetService petService;

    public PetController() {
    }

    @GetMapping
    public ResponseEntity<List<Pet>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(
                this.petService.getAllService()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findByID(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(
                this.petService.getByIdService(id)
        );
    }

    @PostMapping
    public ResponseEntity<Pet> save(@RequestBody Pet newPet){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.petService.saveService(newPet)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.petService.deleteService(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Pet> update(@PathVariable Long id, @Validated @RequestBody Pet pet){
        pet.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                this.petService.updateService(pet)
        );
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Map<String, Object>>> getByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(
                this.petService.findByNameService(name)
        );
    }
}
