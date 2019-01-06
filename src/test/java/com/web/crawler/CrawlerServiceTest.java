package com.web.crawler;

import com.web.crawler.service.CrawlerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;

@RunWith(JUnit4.class)
public class CrawlerServiceTest {

    private CrawlerService underTest;

    @Before
    public void Setup() {
        underTest = new CrawlerService();
    }

    @Test
    public void shouldReturnExpectedNumberOfLinks(){
        Assert.assertEquals(2, underTest.storeLinks("https://www.test.com/", new HashSet<>()).size());
    }
}
