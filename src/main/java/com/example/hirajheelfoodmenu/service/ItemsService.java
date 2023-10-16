package com.example.hirajheelfoodmenu.service;

import com.example.hirajheelfoodmenu.model.Items;
import com.example.hirajheelfoodmenu.response.CommonResponse;

public interface ItemsService {
    CommonResponse getAllItems();
    CommonResponse getItem(long itemId);
    CommonResponse deleteItem(long itemId);
    CommonResponse addItem(Items items);
}
