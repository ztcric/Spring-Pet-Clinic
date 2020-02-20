package com.cliff.springpetclinic.bootstrap;

import com.cliff.springpetclinic.models.Owner;
import com.cliff.springpetclinic.models.Vet;
import com.cliff.springpetclinic.services.OwnerService;
import com.cliff.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Tiancheng");
        owner1.setLastName("Zhu");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Jiahao");
        owner2.setLastName("Song");
        ownerService.save(owner2);

        System.out.println("Loading owners..");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Morris");
        vet1.setLastName("Xi");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Monica");
        vet2.setLastName("Jiang");
        vetService.save(vet2);
        System.out.println("Loading vets...");

    }

}
