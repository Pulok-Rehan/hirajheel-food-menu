package com.example.hirajheelfoodmenu.model;

import com.example.hirajheelfoodmenu.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(value = EnumType.STRING)
    private CategoryEnum name;
    @OneToMany
    @JoinColumn(name = "image_id")
    private Image image;

}
