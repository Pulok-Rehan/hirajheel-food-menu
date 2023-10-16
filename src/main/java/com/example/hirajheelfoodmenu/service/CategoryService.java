package com.example.hirajheelfoodmenu.service;

import com.example.hirajheelfoodmenu.model.Categories;
import com.example.hirajheelfoodmenu.response.CommonResponse;
import com.fasterxml.jackson.core.JsonProcessingException;


public interface CategoryService {
    CommonResponse getAllCategories();
    CommonResponse addCategory(Categories categories) throws JsonProcessingException;
    CommonResponse getCategory(long categoryid);
    CommonResponse deleteCategory(long categoryId);
}
