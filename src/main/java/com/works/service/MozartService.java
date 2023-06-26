package com.works.service;

import com.works.Models.Item;
import com.works.Models.MusicCategory;
import com.works.Models.MusicCategoryList;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MozartService {

    public MusicCategoryList result(){

        String baseUrl = "http://yiboyoung.com/music/mozart/mozart_complete/1EARLIERSYMPHONIES/EARLYSYMPHONIES.htm";
        String baseMusicUrl = "http://yiboyoung.com/music/mozart/mozart_complete/1EARLIERSYMPHONIES/";
        Map<Integer, String> hmTitle = new HashMap<>();
        List<Item> items = new ArrayList<>();
        try {

            Document doc = Jsoup.connect(baseUrl).timeout(15000).ignoreContentType(true).get();
            Elements fonts = doc.getElementsByAttributeValue("size","+2");

            int countTitle = 0;
            for (Element item:fonts) {
                String objTitle = item.toString();
                if (!objTitle.contains("a href=")) {
                    String title = item.text();
                    if (!title.isEmpty()) {
                        hmTitle.put(countTitle,title);
                        countTitle++;
                    }

                } else {
                    String subTitle = item.text().toString();
                    if (!subTitle.isEmpty()) {
                        String href = baseMusicUrl + item.getAllElements().attr("href");

                        Item item1 = new Item();
                        item1.setBaseCat(countTitle);
                        item1.setTitle(subTitle);
                        item1.setUrl(href);

                    }
                }

            }

        }catch (Exception exception){
            System.err.println("mozart err: "+ exception);
        }
        MusicCategoryList musicCategoryList = new MusicCategoryList();
        musicCategoryList.setMusicCategories( parseData( hmTitle, items ) );

        return musicCategoryList;
    }

    private List<MusicCategory> parseData(Map<Integer, String> hmTitle, List<Item> items) {
        Set<Integer> keys = hmTitle.keySet();
        List<MusicCategory>  musicCategories = new ArrayList<>();
        for (Integer key : keys){
            MusicCategory musicCategory = new MusicCategory();
            musicCategory.setBaseTitle(hmTitle.get(key));
            List<Item> itemList = new ArrayList<>();
            for (Item item : items){
                if (item.getBaseCat() - 1 == key){
                    itemList.add(item);

                }
                musicCategory.setItemList(itemList);
                musicCategories.add(musicCategory);
            }
        }
        return musicCategories;
    }

}
