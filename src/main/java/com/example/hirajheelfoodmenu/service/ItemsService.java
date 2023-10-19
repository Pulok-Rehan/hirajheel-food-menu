package com.example.hirajheelfoodmenu.service;

import com.example.hirajheelfoodmenu.model.Items;
import com.example.hirajheelfoodmenu.response.CommonResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ItemsService {
    CommonResponse getAllItems(long categoryId) throws JsonProcessingException;
    CommonResponse getItem(long itemId) throws JsonProcessingException;
    CommonResponse deleteItem(long itemId);
    CommonResponse addItem(Items items) throws JsonProcessingException;
}
