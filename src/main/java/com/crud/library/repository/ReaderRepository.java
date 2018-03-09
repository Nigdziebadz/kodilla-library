package com.crud.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Reader;

@Component
@Transactional
public interface ReaderRepository extends CrudRepository<Reader, Long> {

    Reader save(Reader reader);

    void deleteById(Long readerId);

    Reader getReaderById(Long readerId);
}