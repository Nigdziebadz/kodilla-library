package com.crud.library.controller;

import com.crud.library.domain.Rental;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.ExemplarDto;
import com.crud.library.domain.dto.RentalDto;
import com.crud.library.domain.dto.UserDto;
import com.crud.library.mapper.LibraryMapper;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.ExemplarRepository;
import com.crud.library.repository.RentalRepository;
import com.crud.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("kodilla/library")
public class LibraryController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ExemplarRepository exemplarRepository;
    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addUser", consumes = APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody UserDto userDto) {
        userRepository.save(libraryMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addBook", consumes = APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody BookDto bookDto) {
        bookRepository.save(libraryMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addExemplar", consumes = APPLICATION_JSON_VALUE)
    public void addExemplar(@RequestBody ExemplarDto exemplarDto) {
        exemplarRepository.save(libraryMapper.mapToExemplar(exemplarDto));
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "updateExemplar", consumes = APPLICATION_JSON_VALUE)
//    public ExemplarDto updateExemplar(@RequestBody ExemplarDto exemplarDto) {
//        Exemplar fetchedExemplar = exemplarRepository.findById(exemplarDto.getId()).get();
//        fetchedExemplar.setStatus(exemplarDto.getStatus());
//        return libraryMapper.mapToExemplarDto(exemplarRepository.save(fetchedExemplar));
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "getExemplars")
//    public List<ExemplarDto> getExemplars(@RequestParam long bookId) {
//        return libraryMapper.mapToExemplarsList(exemplarRepository.findExemplarsByBookId(bookId));
//    }

    @RequestMapping(method = RequestMethod.POST, value = "rentExemplar")
    public void rentExemplar(@RequestParam long userId, long exemplarId) {
        rentalRepository.save(new Rental(userId,exemplarId, LocalDateTime.now(), null));
    }

    @RequestMapping(method = RequestMethod.POST, value = "returnExemplar")
    public RentalDto returnExemplar(@RequestParam long exemplarId) {
        Rental fetchedRent = rentalRepository.findById(exemplarId).get();
        fetchedRent.setReturnDate(LocalDateTime.now());
        return libraryMapper.mapToRentalDto(rentalRepository.save(fetchedRent));
    }
}