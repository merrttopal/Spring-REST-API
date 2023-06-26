package com.works.Models;

import lombok.Data;

import java.util.List;

@Data
public class MusicCategory {
    private String baseTitle;
    private List<Item> itemList;

}
