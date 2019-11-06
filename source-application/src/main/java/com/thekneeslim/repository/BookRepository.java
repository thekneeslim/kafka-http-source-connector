package com.thekneeslim.repository;

import com.thekneeslim.contract.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {

    private List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
