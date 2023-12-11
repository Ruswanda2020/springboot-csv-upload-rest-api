package com.ruswanda.csv.controller;

import com.ruswanda.csv.entity.Book;
import com.ruswanda.csv.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {

    private BookService bookService;

    @GetMapping("/list")
    public ResponseEntity<List<Book>> findAllBook(){
        return ResponseEntity.ok().body(bookService.findAll());
    }

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file){
        bookService.save(file);
        return ResponseEntity.created(URI.create("/books/upload")).build();
    }
}
