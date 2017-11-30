package com.crypto.monitor.service.impl;

import com.crypto.monitor.domain.ZebPay;
import com.crypto.monitor.service.APICrawlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class APICrawlerServiceImpl implements APICrawlerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(APICrawlerService.class);

    private static final String ZEB_PAY = "https://www.zebapi.com/api/v1/market/ticker/btc/inr";

    @Override
    public ZebPay crawl() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        RestTemplate restTemplate = new RestTemplate();
        Future<ZebPay> zebPayFuture = executorService.submit(this::getZebPay);
        try {
            return zebPayFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    private ZebPay getZebPay() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(ZEB_PAY, ZebPay.class);
    }
}
