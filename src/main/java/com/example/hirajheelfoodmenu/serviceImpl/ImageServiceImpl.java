package com.example.hirajheelfoodmenu.serviceImpl;

import com.example.hirajheelfoodmenu.model.Image;
import com.example.hirajheelfoodmenu.repository.ImageRepository;
import com.example.hirajheelfoodmenu.response.CommonResponse;
import com.example.hirajheelfoodmenu.response.FailedResponse;
import com.example.hirajheelfoodmenu.service.ImageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ObjectMapper objectMapper;

    public ImageServiceImpl(ImageRepository imageRepository, ObjectMapper objectMapper) {
        this.imageRepository = imageRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public CommonResponse uploadImage(MultipartFile file) {
        if (file == null){
            log.info("FILE CAN NOT BE NULL FOR UPLOADING IMAGE");
            return FailedResponse.makeFailedResponseBody();
        }
        try {
            Image savedImage = imageRepository.save(Image.builder()
                    .image(file.getBytes())
                    .imagetype(file.getContentType()).build());
            log.info("FILE SAVED SUCCESSFULLY");
            return CommonResponse.builder()
                    .hasError(false)
                    .message("Image uploaded successfully")
                    .content(objectMapper.writeValueAsString(savedImage)).build();
        } catch (IOException e) {
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }

    @Override
    public CommonResponse getImage(long id) {
        log.info("ENTERED SERVICE LAYER FOR GETTING IMAGE...");
        try {
            Optional<Image> image = imageRepository.findById(id);
            if (image.isEmpty()){
                log.info("IMAGE COULD NOT BE FOUND FOR DELETING");
                return FailedResponse.makeFailedResponseBody();
            }
            return CommonResponse.builder()
                    .hasError(false)
                    .message("Image found")
                    .content(objectMapper.writeValueAsString(
                            Image.builder()
                                    .id(image.get().getId())
                                    .image(image.get().getImage())
                                    .imagetype(image.get().getImagetype()).build()
                    )).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }

    @Override
    public CommonResponse deleteImage(long id) {
        log.info("ENTERED SEVICE LAYER FR DELETING IMAGE...");
        try {
            imageRepository.deleteById(id);
            log.info("IMAGE DELETED SUCCESSFULLy");
            return CommonResponse.builder()
                    .hasError(false)
                    .message("Image deleted succesfully")
                    .content(null).build();
        }
        catch (Exception e) {
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
}
