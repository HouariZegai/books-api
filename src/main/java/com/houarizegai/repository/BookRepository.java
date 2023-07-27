package com.houarizegai.repository;

import com.houarizegai.dto.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @Inject
    Logger logger;

    private final List<Book> books;

    public BookRepository(@ConfigProperty(name = "books.category", defaultValue = "History") String category) {
        books = List.of(
                new Book(1, "Clean Architecture", 35.5, category),
                new Book(2, "Clean Code", 25.5, "Science")
        );
    }


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
