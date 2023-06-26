package com.works.service;

import com.works.Models.NewsItem;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class NewsService {


    public   List<NewsItem> news(){
        List<NewsItem> newsItemList = new ArrayList<>();

        try {
            String url = "https://www.haberler.com";
            Document doc = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get();
            Elements elements = doc.getElementsByAttribute("data-headlinenumber");

            for (Element item: elements){
                String title = item.attr("title");
                String href = url + item.attr("href");
                String src = item.getElementsByTag("img").attr("data-src");
                if(!title.isEmpty() && !href.isEmpty() && !src.isEmpty()){
                    NewsItem newsItem = new NewsItem();
                    newsItem.setTitle(title);
                    newsItem.setHref(href);
                    newsItem.setSrc(src);

                    newsItemList.add(newsItem);

                }


            }
        }catch (Exception e){
            System.out.println("News Error: " + e);
        }

        return newsItemList;
    }

}
