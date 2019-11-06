package com.thekneeslim.contract;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Book {

    private final long id;
    private final String title;
    private final String description;
    private final String author;
    private final Instant publishingDate;
    private final Instant procuredTime;

}
