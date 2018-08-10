package com.fredy.projectbackend.Repositories;
import com.fredy.projectbackend.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
