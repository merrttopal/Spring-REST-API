package com.works.service;

import com.works.Models.Plant;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantService {

    public List<Plant> plantList(){
        List<Plant> list = new ArrayList<>();
        try {
            String url = "https://www.w3schools.com/xml/plant_catalog.xml";
            String stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString();
            Document document = Jsoup.parse(stData, Parser.xmlParser());
            Elements elements= document.getElementsByTag("Plant");
            for(Element item : elements){
                String common = item.getElementsByTag("common").text();
                String botanical = item.getElementsByTag("botanical").text();
                String ligt = item.getElementsByTag("LIGHT").text();
                String price = item.getElementsByTag("PRICE").text();
                Plant plant = new Plant(common,botanical,ligt,price);
                list.add(plant);
            }
        }catch (Exception e){

        }
        return list;
    }
}
