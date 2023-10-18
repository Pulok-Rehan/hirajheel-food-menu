package com.example.hirajheelfoodmenu.repository;

import com.example.hirajheelfoodmenu.dto.HirajheelAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<HirajheelAdmin, String> {
}
