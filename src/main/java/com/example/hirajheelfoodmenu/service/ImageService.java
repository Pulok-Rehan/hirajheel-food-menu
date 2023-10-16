package com.example.hirajheelfoodmenu.service;

import com.example.hirajheelfoodmenu.dto.ImageDto;
import com.example.hirajheelfoodmenu.model.Image;
import com.example.hirajheelfoodmenu.response.CommonResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    CommonResponse uploadImage(MultipartFile file);
    CommonResponse getImage(long id);
    CommonResponse deleteImage(long id);
}
