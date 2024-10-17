package com.booklend.BookLend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="books")
public class Books {
    @Id
    @Column(name="id_book")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="image")
    private String image;

}
