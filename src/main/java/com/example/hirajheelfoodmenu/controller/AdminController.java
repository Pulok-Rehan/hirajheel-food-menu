package com.example.hirajheelfoodmenu.controller;

import com.example.hirajheelfoodmenu.dto.HirajheelAdmin;
import com.example.hirajheelfoodmenu.response.CommonResponse;
import com.example.hirajheelfoodmenu.response.FailedResponse;
import com.example.hirajheelfoodmenu.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(path = "/login")
    public CommonResponse login(@RequestBody HirajheelAdmin hirajheelAdmin){
        log.info("ENTERED ADMIN CONTROLLER FOR LOGGING IN...");
        try {
            return adminService.isValidUser(hirajheelAdmin);
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
}
