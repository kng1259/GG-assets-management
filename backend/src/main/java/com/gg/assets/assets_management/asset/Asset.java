package com.gg.assets.assets_management.asset;

import com.gg.assets.assets_management.department.Department;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity(name = "assets")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Long quantity;

    @NonNull
    private Double price;

    @NonNull
    private String status;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "department_id")
    private Department department;
}
