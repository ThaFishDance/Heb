package com.tcb.heb.repositories;

import com.tcb.heb.entities.Address;
import org.springframework.data.repository.CrudRepository;

// The class is implemented at runtime
public interface AddressRepository extends CrudRepository<Address, Long> {
}