package com.crud.library.repository;

import com.crud.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {

    Book save(Book book);

    void deleteById(Long titleId);

    Book getTitleById(Long titleId);
}