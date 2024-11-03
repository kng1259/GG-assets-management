package com.gg.assets.assets_management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gg.assets.assets_management.user.User;
import com.gg.assets.assets_management.user.UserRepository;
import com.gg.assets.assets_management.asset.Asset;
import com.gg.assets.assets_management.asset.AssetRepository;

@Configuration
public class SeedDatabase {
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, AssetRepository assetRepository) throws Exception {
        User user1 = new User("user1");
        User user2 = new User("user2");
        Asset asset2 = new Asset("asset2", 20L, 20, "ACTIVE");
        Asset asset1 = new Asset("asset1", 10L, 10, "ACTIVE");
        Asset asset3 = new Asset("asset3", 30L, 30, "ACTIVE");
        userRepository.save(user1);
        userRepository.save(user2);
        assetRepository.save(asset1);
        assetRepository.save(asset2);
        assetRepository.save(asset3);

        return args -> {
            System.out.println("Seeding done");
        };
    }

}
