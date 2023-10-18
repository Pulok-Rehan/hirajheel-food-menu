package com.example.hirajheelfoodmenu.repository;

import com.example.hirajheelfoodmenu.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemsRepository extends JpaRepository<Items, Long> {
    Optional<Items> findByCategoriesId(Long aLong);
}
