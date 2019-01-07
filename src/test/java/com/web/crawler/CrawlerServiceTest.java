package com.web.crawler;

import com.web.crawler.service.CrawlerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;
import java.util.Set;

@RunWith(JUnit4.class)
public class CrawlerServiceTest {

    private CrawlerService underTest;

    @Before
    public void Setup() {
        underTest = new CrawlerService();
    }

    @Test
    public void shouldReturnExpectedNumberOfLinks(){
        Assert.assertEquals(2, underTest.storeLinks("https://www.test.com/").size());
    }

    @Test
    public void shouldReturnKnownLinks(){
        Assert.assertEquals(true, underTest.storeLinks("https://www.test.com/").contains("http://www.w3.org/TR/html4/strict.dtd"));
    }

    @Test
    public void shouldReturnAllLinksForGivenURL(){
        Set<String> testPool = new HashSet<>();
        testPool.add("https://github.com/spring-io/initializr/");
        testPool.add("https://start.spring.io/");
        testPool.add("https://run.pivotal.io");
        testPool.add("https://www.googletagmanager.com/gtm.js?id\u003d");

        Assert.assertEquals(testPool, underTest.storeLinks("https://start.spring.io/"));
    }
}
