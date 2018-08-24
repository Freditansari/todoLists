package com.fredy.projectbackend.Controllers;

import com.fredy.projectbackend.Models.Book;

import com.fredy.projectbackend.Repositories.BookRepository;
import com.fredy.projectbackend.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {
//    private String imageName;
    @Autowired
    BookRepository bookRepo;

    @Autowired
    BookService bookService;

    @PostMapping(value ="/insertBook", produces="application/json")
    public Book addBook(@RequestBody Book book, Principal principal){
//          bookRepo.save(book);
          return bookService.save(book);

    }

    @PostMapping(value = "/insertBook/addImage" )
    public ResponseEntity upload(@RequestParam("id") Long id, HttpServletResponse response, HttpServletRequest request){
        try {
            Book book = bookService.findOne(id);
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multipartRequest.getFileNames();
            MultipartFile multipartFile= multipartRequest.getFile(it.next());
            String filename = id+".png";


            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/image/"+filename)));
            stream.write(bytes);
            stream.close();
            return new ResponseEntity("upload success!", HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("upload failed", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value ="/getBooks", produces="application/json")
    public List<Book> getBooks(){
        return bookService.findAll();
    }
}
