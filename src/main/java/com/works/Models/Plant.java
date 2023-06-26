package com.works.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Plant {
    private String common;
    private String botanical;
    private String light;
    private String price;

}
