package com.example.hirajheelfoodmenu.serviceImpl;

import com.example.hirajheelfoodmenu.model.Items;
import com.example.hirajheelfoodmenu.repository.ItemsRepository;
import com.example.hirajheelfoodmenu.response.CommonResponse;
import com.example.hirajheelfoodmenu.response.FailedResponse;
import com.example.hirajheelfoodmenu.service.ItemsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@ToString
public class ItemsServiceImpl implements ItemsService {
    private final ItemsRepository itemsRepository;
    private final ObjectMapper objectMapper;

    public ItemsServiceImpl(ItemsRepository itemsRepository, ObjectMapper objectMapper) {
        this.itemsRepository = itemsRepository;
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
    public CommonResponse addItem(Items items) {
        return CommonResponse.builder().hasError(Boolean.FALSE).content(itemsRepository.save(items).toString()).build();
    }
}
