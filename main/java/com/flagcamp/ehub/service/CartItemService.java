package com.flagcamp.ehub.service;

import com.flagcamp.ehub.model.CartItem;
import com.flagcamp.ehub.model.CartItemKey;
import com.flagcamp.ehub.model.Item;
import com.flagcamp.ehub.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void addItemToCart(CartItem cartItem, int quantity) {
        CartItem existItem = cartItemRepository.findByCartItem(cartItem);
        if (existItem != null) {
            existItem.setCount(existItem.getCount() + quantity);
            cartItemRepository.save(existItem);
        } else {
            CartItem newcartItem = new CartItem();
            newcartItem.setCount(quantity);
            newcartItem.setCartItemKey(cartItem.getCartItemKey());
            cartItemRepository.save(newcartItem);
        }
    }
}
