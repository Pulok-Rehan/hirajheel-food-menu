package com.example.hirajheelfoodmenu.model;

import com.example.hirajheelfoodmenu.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(value = EnumType.STRING)
    private CategoryEnum name;
    @OneToOne
    private Image image;
}
