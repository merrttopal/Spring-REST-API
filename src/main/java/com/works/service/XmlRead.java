package com.works.service;

import com.works.Models.XmlCurrency;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Service
public class XmlRead {


    public List<XmlCurrency> result(){
        List<XmlCurrency> ls = new ArrayList<>();
        try {
            String url = "https://www.tcmb.gov.tr/kurlar/today.xml";
            String stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString();
            Document document = Jsoup.parse(stData, Parser.xmlParser());
            Elements elements = document.getElementsByTag("Currency");
            for (Element item : elements){
                String currencyName = item.getElementsByTag("CurrencyName").text();
                String forexBuying = item.getElementsByTag("ForexBuying").text();
                String forexSelling = item.getElementsByTag("ForexSelling").text();
                String banknoteBuying = item.getElementsByTag("BanknoteBuying").text();
                String banknoteSelling = item.getElementsByTag("BanknoteSelling").text();
                XmlCurrency xmlCurrency = new XmlCurrency(currencyName,forexBuying,forexSelling,banknoteBuying,banknoteSelling);
                ls.add(xmlCurrency);
            }
        }catch (Exception ex){
            System.err.println("Result err: "+ ex);
        }
        return ls;
    }
}
