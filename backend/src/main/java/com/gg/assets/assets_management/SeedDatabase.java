package com.gg.assets.assets_management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gg.assets.assets_management.department.Department;
import com.gg.assets.assets_management.department.DepartmentRepository;
import com.gg.assets.assets_management.user.User;
import com.gg.assets.assets_management.user.UserRepository;
import com.gg.assets.assets_management.user.UserService;

import jakarta.transaction.Transactional;

import com.gg.assets.assets_management.asset.Asset;
import com.gg.assets.assets_management.asset.AssetRepository;

@Configuration
public class SeedDatabase {
    @Bean
    @Transactional
    CommandLineRunner initDatabase(
            UserRepository userRepository,
            DepartmentRepository departmentRepository,
            UserService userService)
            throws Exception {
        Department department1 = new Department("department1");
        Department department2 = new Department("department2");
        User user1 = new User("user1", "a@g.c", "123", department1);
        User user2 = new User("user2", "b@g.c", "123", department2);
        departmentRepository.save(department1);
        departmentRepository.save(department2);
        Asset asset2 = new Asset("asset2", 20L, 20.0, "ACTIVE", department1);
        Asset asset1 = new Asset("asset1", 10L, 10.0, "ACTIVE", department1);
        Asset asset3 = new Asset("asset3", 30L, 30.0, "ACTIVE", department1);
        userRepository.save(user1);
        userRepository.save(user2);
        userService.addAssetToUser(user1.getId(), asset1);
        userService.addAssetToUser(user1.getId(), asset2);
        userService.addAssetToUser(user1.getId(), asset3);

        return args -> {
            System.out.println("Seeding done");
        };
    }

}
