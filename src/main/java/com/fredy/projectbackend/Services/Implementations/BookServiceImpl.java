package com.fredy.projectbackend.Services.Implementations;

import com.fredy.projectbackend.Models.Book;
import com.fredy.projectbackend.Repositories.BookRepository;
import com.fredy.projectbackend.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> bookList = bookRepository.findBooksByActiveIsTrue();
        return bookList;
    }

    @Override
    public Book findOne(Long id) {
        return bookRepository.getOne(id);

    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> blurrySearch(String keyword) {
        return bookRepository.findBooksByTitleContaining(keyword);
    }

    @Override
    public void removeOne(Long id) {
        bookRepository.deleteById(id);

    }
}
