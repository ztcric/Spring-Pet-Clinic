package com.cliff.springpetclinic.repositories;

import com.cliff.springpetclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;


public interface PetRepository extends CrudRepository<Pet, Long> {
}
