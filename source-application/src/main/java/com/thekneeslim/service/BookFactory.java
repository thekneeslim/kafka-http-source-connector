package com.thekneeslim.service;

import com.thekneeslim.contract.Book;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

public class BookFactory {

    private static long counter = 1L;

    public static Book create() {
        Book book = new Book(counter,
                "Lord Of The Rings",
                "In the land of Modor where the shadow lie",
                "J.R.R. Tolkien",
                LocalDateTime.of(1954, Month.JULY, 29, 5, 30, 30)
                        .atZone(ZoneId.of("Europe/Paris"))
                        .toInstant(),
                Instant.now()
        );
        counter++;
        return book;
    }

    public static Book create(Instant instant) {
        Book book = new Book(counter,
                "Lord Of The Rings",
                "In the land of Modor where the shadow lie",
                "J.R.R. Tolkien",
                LocalDateTime.of(1954, Month.JULY, 29, 5, 30, 30)
                        .atZone(ZoneId.of("Europe/Paris"))
                        .toInstant(),
                instant
        );
        counter++;
        return book;
    }
}
