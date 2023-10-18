package com.example.hirajheelfoodmenu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String imagetype;
    @Lob
    @Column( length = 100000 )
    private byte[] image;
    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categories;

}
