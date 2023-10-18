package com.example.hirajheelfoodmenu.serviceImpl;

import com.example.hirajheelfoodmenu.dto.HirajheelAdmin;
import com.example.hirajheelfoodmenu.repository.AdminRepository;
import com.example.hirajheelfoodmenu.response.CommonResponse;
import com.example.hirajheelfoodmenu.response.FailedResponse;
import com.example.hirajheelfoodmenu.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public CommonResponse isValidUser(HirajheelAdmin hirajheelAdmin) {
        log.info("ENTERED SEVICE LAYED FOR LOGGING IN...");
        try {
            Optional<HirajheelAdmin> tempHirajheelAdmin = adminRepository.findById(hirajheelAdmin.getUsername());
            if (tempHirajheelAdmin.isEmpty()){
                return FailedResponse.makeFailedResponseBody();
            }
            if (hirajheelAdmin.getPassword() == tempHirajheelAdmin.get().getPassword()){
                return CommonResponse.builder()
                        .hasError(false)
                        .message("Username and Password matched")
                        .content("true").build();
            }
            else {
                return FailedResponse.makeFailedResponseBody();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return FailedResponse.makeFailedResponseBody();
        }
    }
}
