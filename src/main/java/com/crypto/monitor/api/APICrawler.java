package com.crypto.monitor.api;

import com.crypto.monitor.domain.ZebPay;
import com.crypto.monitor.service.APICrawlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APICrawler {
    private static final Logger LOGGER = LoggerFactory.getLogger(APICrawler.class);
    private final APICrawlerService apiCrawlerService;

    @Autowired
    public APICrawler(APICrawlerService apiCrawlerService) {
        this.apiCrawlerService = apiCrawlerService;
    }

    @GetMapping("/crawl")
    public void crawl() {
        ZebPay response = apiCrawlerService.crawl();
        LOGGER.info(response.toString());
    }
}
