package com.example.hirajheelfoodmenu.repository;

import com.example.hirajheelfoodmenu.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Long> {
}
