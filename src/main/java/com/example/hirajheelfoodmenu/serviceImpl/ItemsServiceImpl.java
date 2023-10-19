package com.example.hirajheelfoodmenu.serviceImpl;

import com.example.hirajheelfoodmenu.model.Categories;
import com.example.hirajheelfoodmenu.model.Image;
import com.example.hirajheelfoodmenu.model.Items;
import com.example.hirajheelfoodmenu.repository.CategoryRepo;
import com.example.hirajheelfoodmenu.repository.ImageRepository;
import com.example.hirajheelfoodmenu.repository.ItemsRepository;
import com.example.hirajheelfoodmenu.response.CommonResponse;
import com.example.hirajheelfoodmenu.response.FailedResponse;
import com.example.hirajheelfoodmenu.service.ItemsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ToString
public class ItemsServiceImpl implements ItemsService {
    private final ItemsRepository itemsRepository;
    private final CategoryRepo categoryRepo;
    private final ImageRepository imageRepository;
    private final ObjectMapper objectMapper;

    public ItemsServiceImpl(ItemsRepository itemsRepository, CategoryRepo categoryRepo, ImageRepository imageRepository, ObjectMapper objectMapper) {
        this.itemsRepository = itemsRepository;
        this.categoryRepo = categoryRepo;
        this.imageRepository = imageRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public CommonResponse getAllItems(long categoryId) throws JsonProcessingException {
        Optional<Items> itemsOptional = itemsRepository.findByCategoriesId(categoryId);
        if (itemsOptional.isEmpty()){
            return FailedResponse.makeFailedResponseBody();
        }
        return CommonResponse.builder()
                .hasError(false)
                .message("Items found successfully")
                .content(objectMapper.writeValueAsString(itemsOptional.get())).build();
    }

    @Override
    public CommonResponse getItem(long itemId) throws JsonProcessingException {
        Optional<Items> itemsOptional = itemsRepository.findByCategoriesId(itemId);
        if (itemsOptional.isEmpty()){
            return FailedResponse.makeFailedResponseBody();
        }
        return CommonResponse.builder()
                .hasError(false)
                .message("Items found successfully")
                .content(objectMapper.writeValueAsString(itemsOptional.get())).build();
    }

    @Override
    public CommonResponse deleteItem(long itemId) {
        return null;
    }

    @Override
    public CommonResponse addItem(Items items) throws JsonProcessingException {
        List<Image> images = new ArrayList<>();
        if (items.getCategories().getName() == null){
            Optional<Categories> categories = categoryRepo.findById(items.getCategories().getId());
            categories.ifPresent(items::setCategories);
        }
        for(int i=0 ; i<items.getImages().size(); i++){
            Image image = items.getImages().get(i);
            Optional<Image> imageOptional = imageRepository.findById(image.getId());
            imageOptional.ifPresent(images::add);
        }
        items.setImages(images);
        Items savedItem = itemsRepository.save(items);
        return CommonResponse.builder()
                .hasError(Boolean.FALSE)
                .content(objectMapper.writeValueAsString(savedItem))
                .message("Item added successfully!").build();
    }
}
