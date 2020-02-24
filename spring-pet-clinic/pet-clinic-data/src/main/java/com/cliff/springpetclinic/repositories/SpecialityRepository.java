package com.cliff.springpetclinic.repositories;

import com.cliff.springpetclinic.models.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
