package com.example.quoteapp;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private List<String> quotes = new ArrayList<>(List.of(
        "Stay hungry, stay foolish",
        "Code. Sleep. Repeat.",
        "Consistency > Motivation"
    ));

    @GetMapping
    public List<String> getQuotes() {
        return quotes;
    }

    @PostMapping
    public String addQuote(@RequestBody String quote) {
        quotes.add(quote);
        return "Quote added!";
    }
}
