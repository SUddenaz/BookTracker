package com.example.BookTracker.service;

import com.example.BookTracker.model.Book;
import com.example.BookTracker.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(String title, String author) {
        // 🔄 MULTITHREADING: Kitap ekleme işlemini bir thread içinde çalıştırıyoruz
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000); // sahte bekleme efekti
                repository.save(new Book(title, author));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        thread.start();
    }

    public List<Book> listBooks() {
        // 🔄 MULTITHREADING: Listeleme işlemini simüle ediyoruz
        try {
            Thread.sleep(500); // sahte yavaşlama efekti
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 🔄 SIRALAMA ALGORİTMASI (örnek: kitapları başlığa göre bubble sort ile sırala)
        List<Book> books = new ArrayList<>(repository.findAll());
        bubbleSortByTitle(books);
        return books;
    }

    private void bubbleSortByTitle(List<Book> books) {
        int n = books.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (books.get(j).getTitle().compareToIgnoreCase(books.get(j + 1).getTitle()) > 0) {
                    Book temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
    }

    public List<Book> searchBooks(String keyword) {
        return repository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(keyword, keyword);
    }

    public void markAsRead(int id) {
        repository.findById(id).ifPresent(book -> {
            book.setRead(true);
            repository.save(book);
        });
    }

    public void deleteBook(int id) {
        repository.deleteById(id);
    }
}

