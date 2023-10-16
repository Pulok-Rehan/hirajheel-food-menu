package com.example.hirajheelfoodmenu.controller;

import com.example.hirajheelfoodmenu.dto.ImageDto;
import com.example.hirajheelfoodmenu.response.CommonResponse;
import com.example.hirajheelfoodmenu.response.FailedResponse;
import com.example.hirajheelfoodmenu.service.ImageService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
    @PostMapping(path = "/upload")
    public CommonResponse uploadImage(@RequestParam("file") MultipartFile file){
        log.info("ENTERED CONTROLLER FOR UPLOADING IMAGE...");
        try {
            return imageService.uploadImage(file);
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }

    @PostMapping(path = "/image")
    public CommonResponse getImage(@RequestParam long id){
        log.info("ENTERED CONTROLLER FOR GETTING SINGLE IMAGE...");
        try {
            return imageService.getImage(id);
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }

    @PostMapping(path = "/deleteImage")
    public CommonResponse deleteImage(@RequestParam long id){
        log.info("ENTERED CONTROLLER FOR DELETING IMAGE...");
        try {
            return imageService.deleteImage(id);
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
}
