package com.example.hirajheelfoodmenu.serviceImpl;

import com.example.hirajheelfoodmenu.model.Categories;
import com.example.hirajheelfoodmenu.model.Image;
import com.example.hirajheelfoodmenu.repository.CategoryRepo;
import com.example.hirajheelfoodmenu.repository.ImageRepository;
import com.example.hirajheelfoodmenu.response.CommonResponse;
import com.example.hirajheelfoodmenu.response.FailedResponse;
import com.example.hirajheelfoodmenu.service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ObjectMapper objectMapper;
    private final ImageRepository imageRepository;

    public CategoryServiceImpl(CategoryRepo categoryRepo, ObjectMapper objectMapper, ImageRepository imageRepository) {
        this.categoryRepo = categoryRepo;
        this.objectMapper = objectMapper;
        this.imageRepository = imageRepository;
    }

    @Override
    public CommonResponse getAllCategories() {
        try {
            List<Categories> categoriesList = categoryRepo.findAll();
            if (!categoriesList.isEmpty()){
                return CommonResponse.builder()
                        .hasError(false)
                        .message("Categories found successfully")
                        .content(objectMapper.writeValueAsString(categoriesList)).build();
            }
            return FailedResponse.makeFailedResponseBody();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }

    @Override
    public CommonResponse addCategory(Categories categories) throws JsonProcessingException {
        try {
            if (categories == null){
                log.info("CATEGORY CAN NOT BE NULL");
                return FailedResponse.makeFailedResponseBody();
            }
            if (categories.getImage().getImage() == null || categories.getImage().getImagetype() == null ){
                Optional<Image> image = imageRepository.findById(categories.getImage().getId());
                image.ifPresent(categories::setImage);
            }
            Categories savedCategory = categoryRepo.save(categories);
            return CommonResponse.builder()
                    .hasError(false)
                    .message("Category added successfully")
                    .content(objectMapper.writeValueAsString(savedCategory)).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }

    }

    @Override
    public CommonResponse getCategory(long categoryid) {
        try {
            if (StringUtils.isEmpty(String.valueOf(categoryid))){
                log.info("CATEGORY ID CAN NOT BE EMPTY");
                return FailedResponse.makeFailedResponseBody();
            }
            Optional<Categories> categories = categoryRepo.findById(categoryid);
            if (categories.isPresent()){
                return CommonResponse.builder()
                        .hasError(false)
                        .message("Category found")
                        .content(objectMapper.writeValueAsString(categories)).build();
            }
            return FailedResponse.makeFailedResponseBody();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }

    @Override
    public CommonResponse deleteCategory(long categoryId) {
        try {
            if (StringUtils.isEmpty(String.valueOf(categoryId))){
                log.info("ID CAN NOT BE EMPTY");
                return FailedResponse.makeFailedResponseBody();
            }
            categoryRepo.deleteById(categoryId);
            return CommonResponse.builder()
                    .hasError(false)
                    .message("Deleted Successfully")
                    .content(null).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
}
