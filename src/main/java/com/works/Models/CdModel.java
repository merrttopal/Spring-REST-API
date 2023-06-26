package com.works.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CdModel {
    private String title;
    private String artist;
    private String country;
    private String company;
    private String price;
    private String year;
}
