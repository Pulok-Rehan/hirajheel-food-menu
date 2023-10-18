package com.example.hirajheelfoodmenu.controller;

import com.example.hirajheelfoodmenu.model.Items;
import com.example.hirajheelfoodmenu.response.CommonResponse;
import com.example.hirajheelfoodmenu.response.FailedResponse;
import com.example.hirajheelfoodmenu.service.ItemsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ItemsController {
    private final ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }
    @GetMapping(path = "/items")
    public CommonResponse getAllItems(@RequestParam long categoryId){
        log.info("ENTERED CONTROLLER FOR GETTING ALL ITEMS...");
        try {
            return itemsService.getAllItems(categoryId);
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
    @PostMapping(path = "/addItem")
    public CommonResponse addItem(@RequestBody Items items){
        log.info("ENTERED CONTROLLER FOR ADDING SINGLE ITEM...");
        try {
            if (items == null){
                log.info("ITEM CAN NOT BE NULL");
                return FailedResponse.makeFailedResponseBody();
            }
            return itemsService.addItem(items);
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
    @PostMapping(path = "/deleteItem")
    public CommonResponse deleteItem(@RequestParam long id){
        log.info("ENTERED CONTROLLER FOR DELETING SINGLE ITEM...");
        try {
            return itemsService.deleteItem(id);
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
    @PostMapping(path = "/getItem")
    public CommonResponse getItem(@RequestParam long id){
        try{
            return itemsService.getItem(id);
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
}
