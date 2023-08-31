package com.flagcamp.ehub.controller;

import com.flagcamp.ehub.model.CartItem;
import com.flagcamp.ehub.service.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/cart")
public class CartController {
    private final CartItemService cartItemService;

    public CartController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }
    @PostMapping("/add")
    public ResponseEntity<String> addItemToCart(@RequestParam CartItem cartItem, @RequestParam int quantity) {
        cartItemService.addItemToCart(cartItem, quantity);
        return ResponseEntity.ok("success");
    }
}
