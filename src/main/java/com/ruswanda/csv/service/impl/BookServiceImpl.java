package com.ruswanda.csv.service.impl;

import com.ruswanda.csv.entity.Book;
import com.ruswanda.csv.helper.CsvHelper;
import com.ruswanda.csv.repository.BookRepository;
import com.ruswanda.csv.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> save(MultipartFile file) {
        try {
            List<Book> books = CsvHelper.csvToBook(file.getInputStream());
            return bookRepository.saveAll(books);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store CSV data: " + e.getMessage());
        }
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
