package com.thekneeslim.controller;

import com.thekneeslim.contract.Book;
import com.thekneeslim.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/books", params = {"procureFrom"})
    public List<Book> getAllBooksFrom(@RequestParam("procureFrom") Instant procurementInstant) {
        return bookService.getAllBooksProcuredFrom(procurementInstant);
    }

}
