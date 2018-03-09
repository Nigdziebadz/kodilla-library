package com.crud.library.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface TitleRepository extends CrudRepository<Title, Long> {

    Title save(Title title);

    void deleteById(Long titleId);

    Title getTitleById(Long titleId);
}