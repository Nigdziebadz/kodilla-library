package com.crud.library.repository;

import com.crud.library.domain.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface RentalRepository extends CrudRepository<Rental, Long> {
}