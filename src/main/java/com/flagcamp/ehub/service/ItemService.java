package com.flagcamp.ehub.service;

import com.flagcamp.ehub.model.Item;
import com.flagcamp.ehub.model.ItemImage;
import com.flagcamp.ehub.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ImageService imageService;

    private final ItemRepository itemRepository;

    public ItemService(ImageService imageService, ItemRepository itemRepository) {
        this.imageService = imageService;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public void add(Item item, MultipartFile[] images) {
        List<ItemImage> itemImages = Arrays.stream(images)
                .filter(image -> !image.isEmpty())
                .parallel()
                .map(imageService::save)
                .map(mediaLink -> new ItemImage(mediaLink, item))
                .collect(Collectors.toList());
        item.setImages(itemImages);
        itemRepository.save(item);
    }
}
