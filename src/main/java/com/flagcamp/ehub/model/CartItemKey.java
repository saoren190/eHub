package com.flagcamp.ehub.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartItemKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "username")
    private User buyer;

    public CartItemKey(){}

    public CartItemKey(Item item, User buyer) {
        this.item = item;
        this.buyer = buyer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        CartItemKey that = (CartItemKey) o;
        return Objects.equals(this.buyer, that.buyer) && Objects.equals(this.item, that.item);
    }

    @Override
    public int hashCode(){
        return Objects.hash(buyer, item);
    }
}
