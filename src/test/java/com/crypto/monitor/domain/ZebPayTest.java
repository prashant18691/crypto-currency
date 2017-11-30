package com.crypto.monitor.domain;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ZebPayTest {
    @Test
    public void bindingTest() {
        String sampleData = "{\"market\":717417,\"buy\":717417,\"sell\":706656,\"currency\":\"INR\",\"volume\":2604.5585147}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ZebPay zebpay = objectMapper.readValue(sampleData, ZebPay.class);
            Assert.assertNotNull(zebpay);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
