package com.cliff.springpetclinic.services.map;

import com.cliff.springpetclinic.models.Owner;
import com.cliff.springpetclinic.services.OwnerService;
import com.cliff.springpetclinic.services.PetService;
import com.cliff.springpetclinic.services.PetTypeService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Set;

@ComponentScan
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    //todo
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet ->{
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else{
                        throw new RuntimeException("PetType is required.");
                    }
                    if(pet.getId() == null){
                        petService.save(pet);

                    }
                });
            }

            return super.save(object);
        }
        else{
            return null;
        }

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
