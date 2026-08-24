package com.junior.AgroManager.model;

import com.junior.AgroManager.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "farm_members",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_farm_member_farm_user",
                columnNames = {"farm_id", "user_id"}
        )
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;
}
