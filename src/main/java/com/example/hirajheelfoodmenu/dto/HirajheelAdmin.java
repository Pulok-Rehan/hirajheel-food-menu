package com.example.hirajheelfoodmenu.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class HirajheelAdmin {
    @Id
    private String username;
    private String password;
}
