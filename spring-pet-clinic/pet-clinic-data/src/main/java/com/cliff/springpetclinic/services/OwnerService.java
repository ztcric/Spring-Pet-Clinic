package com.cliff.springpetclinic.services;

import com.cliff.springpetclinic.models.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
