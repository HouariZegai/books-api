package com.houarizegai.repository;

import com.houarizegai.dto.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @Inject
    Logger logger;

    private List<Book> books = List.of(
            new Book(1, "Clean Architecture", 35.5),
            new Book(2, "Clean Code", 25.5)
    );

    public List<Book> getBooks() {
        logger.info("Get all books");
        return books;
    }

    public Optional<Book> getBookById(long bookId) {
        logger.info("Find book with id: " + bookId);
        return books.stream().filter(book -> book.id() == bookId)
                .findFirst();
    }
}
