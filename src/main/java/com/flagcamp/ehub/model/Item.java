package com.flagcamp.ehub.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private UUID item_id;

    private String item_name;

    private String item_description;

    private float item_price;

    private int item_stock;

    @ManyToOne
    @JoinColumn(name = "username")
    private User owner;

    @OneToMany(mappedBy = "Item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemImage> images;

    @OneToMany(mappedBy = "Item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> carts;

    public Item() {}

    public UUID getItem_id() {
        return item_id;
    }

    public void setItem_id(UUID item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public float getItem_price() {
        return item_price;
    }

    public void setItem_price(float item_price) {
        this.item_price = item_price;
    }

    public int getItem_stock() {
        return item_stock;
    }

    public void setItem_stock(int item_stock) {
        this.item_stock = item_stock;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<ItemImage> getImages() {
        return images;
    }

    public void setImages(List<ItemImage> images) {
        this.images = images;
    }

    public List<CartItem> getCarts() {return carts;}

    public void setCarts(List<CartItem> carts) {this.carts = carts;}
}
