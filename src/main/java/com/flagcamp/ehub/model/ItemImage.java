package com.flagcamp.ehub.model;

import javax.persistence.*;

@Entity
public class ItemImage {

    @Id
    private String url;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public ItemImage() {}

    public ItemImage(String url, Item item) {
        this.url = url;
        this.item = item;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
