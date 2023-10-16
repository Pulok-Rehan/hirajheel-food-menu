package com.example.hirajheelfoodmenu.controller;

import com.example.hirajheelfoodmenu.model.Categories;
import com.example.hirajheelfoodmenu.response.CommonResponse;
import com.example.hirajheelfoodmenu.response.FailedResponse;
import com.example.hirajheelfoodmenu.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/categories")
    public CommonResponse getAllCategories(){
        log.info("ENTERED CONTROLLER FOR GETTING ALL CATEGORIES");
        try {
            return categoryService.getAllCategories();
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
    @PostMapping(path = "/category")
    public CommonResponse addCategory(@RequestBody Categories categories){
        log.info("ENTERED CONTROLLER FOR ADDING CATEGORY...");
        try {
            return categoryService.addCategory(categories);
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
    @PostMapping(path = "/deleteCategory")
    public CommonResponse deleteCategory(@RequestParam long id){
        log.info("ENTERED CONTROLLER FOR DELETING CATEGORY...");
        try {
            if (id == 0){
                log.info("ID CAN NOT BE ZERO");
                return FailedResponse.makeFailedResponseBody();
            }
            return categoryService.deleteCategory(id);
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
    @PostMapping(path = "/getCategory")
    public CommonResponse getCategory(@RequestParam long id){
        log.info("ENTERED CONTROLLER FOR GETTING SINGLE CATEGORY...");
        try {
            if (id == 0){
                log.info("ID CAN NOT BE ZERO");
                return FailedResponse.makeFailedResponseBody();
            }
            return categoryService.getCategory(id);
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
}
