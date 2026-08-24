package com.junior.AgroManager.model;

import com.junior.AgroManager.enums.SeasonStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate plantingDate;

    private LocalDate expectedHarvestDate;

    private LocalDate actualHarvestDate;

    @Enumerated(EnumType.STRING)
    private SeasonStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

    @OneToMany(mappedBy = "season")
    private List<Application> applications = new ArrayList<>();

    @OneToMany(mappedBy = "season")
    private List<Recommendation> recommendations = new ArrayList<>();

    @OneToMany(mappedBy = "season")
    private List<Expense> expenses = new ArrayList<>();

    @OneToMany(mappedBy = "season")
    private List<Revenue> revenues = new ArrayList<>();
}
