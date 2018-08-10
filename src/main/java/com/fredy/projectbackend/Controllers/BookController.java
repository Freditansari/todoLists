package com.fredy.projectbackend.Controllers;

import com.fredy.projectbackend.Models.Book;

import com.fredy.projectbackend.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepo;

    @PostMapping(value ="/insertBook", produces="application/json")
    public Object addBook(@RequestBody Book book, Principal principal){

        book.setHolderName(principal.getName());
        bookRepo.save(book);
        return "{\"Message\":\"Success\"}";
    }
}
