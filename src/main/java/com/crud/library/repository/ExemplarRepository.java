package com.crud.library.repository;


import com.crud.library.domain.Exemplar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public interface ExemplarRepository extends CrudRepository<Exemplar, Long> {
    List<Exemplar> findExemplarsByBookId(long bookId);
}
