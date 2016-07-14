package com.gildedrose;

public class GildedRose {

    public String name;
    public Long quality;
    public Long daysRemaining;

    public GildedRose(String name, Long quality, Long daysRemaining) {
        this.name = name;
        this.quality = quality;
        this.daysRemaining = daysRemaining;
    }

    private Boolean isNot(String item) {
        return name != item;
    }

    private Boolean is(String item) {
        return name == item;
    }

    private Boolean lowQuality() {
        return quality < 50;
    }

    public void tick() {


        if (is("Backstage passes to a TAFKAL80ETC concert")) {
            backstagePasses();
        }

        if (is("Sulfuras, Hand of Ragnaros")) {
            sulfuras();
        }

        if (is("Aged Brie")) {
            agedBrie();
        }

        if (isNot("Aged Brie") && isNot("Backstage passes to a TAFKAL80ETC concert") && isNot("Sulfuras, Hand of Ragnaros")) {
            daysRemaining -= 1;
            if (quality > 0) {
                quality -= 1;
            }
        }


        if (daysRemaining < 0) {
            if (isNot("Aged Brie") && isNot("Backstage passes to a TAFKAL80ETC concert")) {
                if (quality > 0 && isNot("Sulfuras, Hand of Ragnaros")) {
                    quality -= 1;
                }
            } else if (isNot("Aged Brie")) {
                quality = quality - quality;
            }
        }
    }

    private void backstagePasses() {
        if (lowQuality()) {
            quality += 1;
            if (daysRemaining < 11) {
                quality += 1;
            }
            if (daysRemaining < 6) {
                quality += 1;
            }
        }
        daysRemaining -= 1;
    }

    private void sulfuras() {
        if (lowQuality()) {
            quality += 1;
        }
    }

    private void agedBrie() {
        daysRemaining -= 1;
        if (lowQuality()) {
            quality += 1;
        }

        if (lowQuality() && daysRemaining < 0) {
            quality += 1;
        }
    }
}