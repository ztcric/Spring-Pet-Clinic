package com.cliff.springpetclinic.repositories;

import com.cliff.springpetclinic.models.Pet;
import com.cliff.springpetclinic.services.CrudService;

public interface PetRepository extends CrudService<Pet, Long> {
}
