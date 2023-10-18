package com.example.hirajheelfoodmenu.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double price;
    @OneToOne
    private Image image;
    @OneToOne
    private Image images;
    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categories;
}
