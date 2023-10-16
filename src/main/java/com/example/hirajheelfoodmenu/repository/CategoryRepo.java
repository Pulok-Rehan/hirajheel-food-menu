package com.example.hirajheelfoodmenu.repository;

import com.example.hirajheelfoodmenu.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Categories, Long>{
}
