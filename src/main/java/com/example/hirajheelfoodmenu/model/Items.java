package com.example.hirajheelfoodmenu.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double price;
    @OneToOne
    private Image image;
    @ManyToOne
    private Categories categories;
}
