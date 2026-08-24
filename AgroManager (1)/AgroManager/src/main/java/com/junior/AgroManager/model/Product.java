package com.junior.AgroManager.model;

import com.junior.AgroManager.enums.ProductCategory;
import com.junior.AgroManager.enums.UnitOfMeasure;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;


    @Enumerated(EnumType.STRING)
    private UnitOfMeasure unit;

    private int minimumStock;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    @OneToMany(mappedBy = "product")
    private List<StockMovement> stockMovements = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<Application> applications = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<Recommendation> recommendations = new ArrayList<>();


}
