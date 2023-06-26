package com.works.restControllers;

import com.works.Models.MusicCategoryList;
import com.works.Models.NewsItem;
import com.works.service.MozartService;
import com.works.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsRestController {
    final NewsService newsService;

    @GetMapping("/service")
    public List<NewsItem> news(){

        return  newsService.news();
    }
}
