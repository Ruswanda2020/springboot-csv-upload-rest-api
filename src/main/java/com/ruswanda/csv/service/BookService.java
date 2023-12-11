package com.ruswanda.csv.service;

import com.ruswanda.csv.entity.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {

    public List<Book> save(MultipartFile file);

    public List<Book> findAll();
}
