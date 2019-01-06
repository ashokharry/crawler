package com.web.crawler.controller;

import com.google.gson.Gson;
import com.web.crawler.service.CrawlerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class CrawlerController {

    private CrawlerService crawlerService;

    public CrawlerController(CrawlerService crawlerService){
        this.crawlerService=crawlerService;
    }

    @GetMapping(value="/site-map")
    String siteMapLookup(@RequestParam("url") String url){
        Set<String> linksPool = new HashSet<>();

        Gson gson = new Gson();
        return gson.toJson(crawlerService.storeLinks(url, linksPool));
    }
}
