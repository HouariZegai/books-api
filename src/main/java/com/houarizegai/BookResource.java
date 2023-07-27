package com.houarizegai;

import com.houarizegai.dto.Book;
import com.houarizegai.repository.BookRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @GET
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @GET
    @Path("/count")
    public int getBooksCount() {
        return bookRepository.getBooks().size();
    }

    @GET
    @Path("/{id}")
    public Optional<Book> getBookById(@PathParam("id") long bookId) {
        return bookRepository.getBookById(bookId);
    }
}
