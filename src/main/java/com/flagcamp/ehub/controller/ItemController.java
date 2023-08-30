package com.flagcamp.ehub.controller;

import com.flagcamp.ehub.service.ItemService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private final ItemService itemService;
}
