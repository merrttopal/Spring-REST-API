package com.works.service;


import com.works.Models.CdModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CdService {
    public List<CdModel> cdModelList(){
        List<CdModel> list = new ArrayList<>();
        try {
            String url = "https://www.w3schools.com/xml/cd_catalog.xml";
            String stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString();
            Document document = Jsoup.parse(stData, Parser.xmlParser());
            Elements elements= document.getElementsByTag("CD");
            for(Element item : elements){
                String title = item.getElementsByTag("title").text();
                String artist = item.getElementsByTag("artist").text();
                String country = item.getElementsByTag("country").text();
                String company = item.getElementsByTag("company").text();
                String price = item.getElementsByTag("price").text();
                String year = item.getElementsByTag("year").text();
                CdModel cdModel = new CdModel(title,artist, country, company, price ,year);
                list.add(cdModel);
            }
        }catch (Exception e){

        }
        return list;
    }

}
