package com.cliff.springpetclinic.repositories;

import com.cliff.springpetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
