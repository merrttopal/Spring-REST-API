package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String title;


    @Size(min = 5, max = 500)
    @NotEmpty
    @NotNull
    private String detail;


    @NotNull
    @PositiveOrZero
    private Integer price;


    @NotNull
    private Boolean status;

}
