package com.workintech.s19d1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Entity
@Table(name = "movie", schema = "cinema")
@Data
public class Movie {
    private Long id;
}
