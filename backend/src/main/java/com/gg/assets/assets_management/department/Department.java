package com.gg.assets.assets_management.department;

import java.util.List;

import com.gg.assets.assets_management.asset.Asset;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NonNull;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity(name = "departments")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Asset> assets;
}
