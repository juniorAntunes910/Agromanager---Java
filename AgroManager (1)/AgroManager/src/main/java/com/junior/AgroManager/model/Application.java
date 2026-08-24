package com.junior.AgroManager.model;

import com.junior.AgroManager.enums.ApplicationMethod;
import com.junior.AgroManager.enums.ApplicationStatus;
import com.junior.AgroManager.enums.ApplicationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ApplicationType type;

    @Enumerated(EnumType.STRING)
    private ApplicationMethod method;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    private double dosage;

    private double area;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recommendation_id")
    private Recommendation recommendation;
}
