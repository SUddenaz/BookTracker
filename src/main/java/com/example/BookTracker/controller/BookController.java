package com.example.BookTracker.controller;

import com.example.BookTracker.model.Book;
import com.example.BookTracker.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseWrapper<String> addBook(@RequestBody Book book) {
        service.addBook(book.getTitle(), book.getAuthor());
        return new ResponseWrapper<>("Kitap ekleme işlemi başlatıldı.");
    }

    @GetMapping
    public ResponseWrapper<List<Book>> listBooks() {
        return new ResponseWrapper<>(service.listBooks());
    }

    @GetMapping("/search")
    public ResponseWrapper<List<Book>> searchBooks(@RequestParam String keyword) {
        return new ResponseWrapper<>(service.searchBooks(keyword));
    }

    @PutMapping("/{id}/read")
    public ResponseWrapper<String> markAsRead(@PathVariable int id) {
        service.markAsRead(id);
        return new ResponseWrapper<>("Kitap okundu olarak işaretlendi.");
    }

    @DeleteMapping("/{id}")
    public ResponseWrapper<String> deleteBook(@PathVariable int id) {
        service.deleteBook(id);
        return new ResponseWrapper<>("Kitap silindi.");
    }
}
