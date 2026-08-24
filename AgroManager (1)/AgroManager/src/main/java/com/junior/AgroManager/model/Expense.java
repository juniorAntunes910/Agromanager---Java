package com.junior.AgroManager.model;

import com.junior.AgroManager.enums.ExpenseCategory;
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
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExpenseCategory category;

    private double amount;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    private Season season;
}
