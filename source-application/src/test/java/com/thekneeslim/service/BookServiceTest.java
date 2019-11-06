package com.thekneeslim.service;

import com.thekneeslim.contract.Book;
import com.thekneeslim.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    private BookService bookService;
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void shouldReturnBooksProcuredAfterGivenDate() {
        Instant instant = LocalDateTime.of(2019, Month.AUGUST, 20, 3, 40, 24)
                .atZone(ZoneId.of("Pacific/Auckland"))
                .toInstant();

        when(bookRepository.getAllBooks()).thenReturn(
                Arrays.asList(
                        BookFactory.create(instant.minus(1, ChronoUnit.DAYS)),
                        BookFactory.create(instant),
                        BookFactory.create(instant.plus(1, ChronoUnit.DAYS)),
                        BookFactory.create(instant.plus(2, ChronoUnit.DAYS))));

        List<Book> books = bookService.getAllBooksProcuredFrom(instant.plus(5, ChronoUnit.MINUTES));
        assertEquals(2, books.size());
    }
}