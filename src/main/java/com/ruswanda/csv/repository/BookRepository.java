package com.ruswanda.csv.repository;

import com.ruswanda.csv.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
