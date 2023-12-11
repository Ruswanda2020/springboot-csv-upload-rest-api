package com.ruswanda.csv.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_book")
public class Book {

   @Id
   private Long id;

   @Column(length = 300,nullable = false)
   private String title;

   @Column(length = 255, nullable = false)
   private String description;

   @Column(length = 12)
   private Double price;

}
