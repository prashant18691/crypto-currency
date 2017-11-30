package com.crypto.monitor.domain;

public class ZebPay {
    private Double market;
    private Double buy;
    private Double sell;
    private String currency;
    private Double volume;

    public Double getMarket() {
        return market;
    }

    public void setMarket(Double market) {
        this.market = market;
    }

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Zebpay{" +
                "market=" + market +
                ", buy=" + buy +
                ", sell=" + sell +
                ", currency='" + currency + '\'' +
                ", volume=" + volume +
                '}';
    }
}
