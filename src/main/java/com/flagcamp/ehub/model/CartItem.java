package com.flagcamp.ehub.model;

import javax.persistence.*;

@Entity
public class CartItem {

    @EmbeddedId
    private CartItemKey cartItemKey;

    private int count;

    public CartItem(){}

    public CartItemKey getCartItemKey() {
        return cartItemKey;
    }

    public void setCartItemKey(CartItemKey cartItemKey) {
        this.cartItemKey = cartItemKey;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
