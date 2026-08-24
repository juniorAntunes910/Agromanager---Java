package com.junior.AgroManager.model;

import com.junior.AgroManager.enums.FarmStatus;
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
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double totalArea;

    @Enumerated(EnumType.STRING)
    private FarmStatus status;

    @OneToMany(mappedBy = "farm")
    private List<Field> fields = new ArrayList<>();

    @OneToMany(mappedBy = "farm")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "farm")
    private List<Expense> expenses = new ArrayList<>();

    @OneToMany(mappedBy = "farm")
    private List<Revenue> revenues = new ArrayList<>();

    @OneToMany(mappedBy = "farm")
    private List<FarmMember> members = new ArrayList<>();
}
