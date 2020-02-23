package com.cliff.springpetclinic.bootstrap;

import com.cliff.springpetclinic.models.*;
import com.cliff.springpetclinic.services.OwnerService;
import com.cliff.springpetclinic.services.PetTypeService;
import com.cliff.springpetclinic.services.SpecialityService;
import com.cliff.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Tiancheng");
        owner1.setLastName("Zhu");
        owner1.setAddress("123 Freeman St");
        owner1.setCity("Boston");
        owner1.setTelephone("1234313223");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogType);
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        pet1.setName("Judy");
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jiahao");
        owner2.setLastName("Song");
        owner2.setAddress("123 Freeman St");
        owner2.setCity("Boston");
        owner2.setTelephone("1234313223");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatType);
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner2);
        pet2.setName("Fifi");
        owner2.getPets().add(pet2);
        ownerService.save(owner2);

        System.out.println("Loading owners..");

        Vet vet1 = new Vet();
        vet1.setFirstName("Morris");
        vet1.setLastName("Xi");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Monica");
        vet2.setLastName("Jiang");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Loading vets...");
    }

}
