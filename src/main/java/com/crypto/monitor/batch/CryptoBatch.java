package com.crypto.monitor.batch;

import com.crypto.monitor.service.APICrawlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Profile("batch")
@Component
public class CryptoBatch {
    private static final Logger LOGGER = LoggerFactory.getLogger(CryptoBatch.class);

    @Autowired
    private APICrawlerService apiCrawlerService;

    @Scheduled(cron = "${batch.crypto.cron}")
    public void cronJob() {
        LOGGER.info(apiCrawlerService.crawl().toString());
    }
}
