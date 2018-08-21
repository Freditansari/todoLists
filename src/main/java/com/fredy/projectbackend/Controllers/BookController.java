package com.fredy.projectbackend.Controllers;

import com.fredy.projectbackend.Models.Book;

import com.fredy.projectbackend.Repositories.BookRepository;
import com.fredy.projectbackend.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepo;

    @Autowired
    BookService bookService;

    @PostMapping(value ="/insertBook", produces="application/json")
    public Object addBook(@RequestBody Book book, Principal principal){
//          bookRepo.save(book);
          bookService.save(book);
          return "{\"Message\":\"Success\"}";
    }

    @PostMapping(value ="/getBooks", produces="application/json")
    public List<Book> getBooks(){
        return bookRepo.findAll();
    }
}
