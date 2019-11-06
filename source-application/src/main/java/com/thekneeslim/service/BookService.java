package com.thekneeslim.service;

import com.thekneeslim.contract.Book;
import com.thekneeslim.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void publish() {
        repository.add(BookFactory.create());
    }

    public List<Book> getAllBooks() {
        return repository.getAllBooks();
    }

    public List<Book> getAllBooksProcuredFrom(Instant procurementInstant) {
        return repository.getAllBooks()
                .stream()
                .filter(book -> book.getProcuredTime().isAfter(procurementInstant))
                .collect(Collectors.toList());
    }

}
