package com.flagcamp.ehub.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class CartItemKey implements Serializable {

    private UUID item;

    private String buyer;

    public CartItemKey(){}

    public CartItemKey(UUID item, String buyer) {
        this.item = item;
        this.buyer = buyer;
    }

    public UUID getItem() {
        return item;
    }

    public void setItem(UUID item) {
        this.item = item;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
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
