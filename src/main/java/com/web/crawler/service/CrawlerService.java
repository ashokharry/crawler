package com.web.crawler.service;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CrawlerService {

    public Set<String> storeLinks(String urlLink, Set<String> linksPool) {

        if(!linksPool.contains(urlLink)){
            linksPool.add(urlLink);

            try{
                URL url = new URL(urlLink);
                String content = IOUtils.toString(url, "UTF-8");
                Set<String> allLinks = new HashSet<>();

                String regex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(content);
                while (m.find()){
                    allLinks.add(m.group());
                }

                for (String str : allLinks) {
                    if (str.startsWith(urlLink)) {
                        storeLinks(str, linksPool);
                    }else{
                        linksPool.add(str);
                    }
                }
            }
            catch (Exception e)
            { e.printStackTrace();
            }
        }
        return linksPool;
    }
}
