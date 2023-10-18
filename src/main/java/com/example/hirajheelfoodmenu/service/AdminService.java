package com.example.hirajheelfoodmenu.service;

import com.example.hirajheelfoodmenu.dto.HirajheelAdmin;
import com.example.hirajheelfoodmenu.response.CommonResponse;

public interface AdminService {
    CommonResponse isValidUser(HirajheelAdmin hirajheelAdmin);
}
