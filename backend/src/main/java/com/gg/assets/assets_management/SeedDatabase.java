package com.gg.assets.assets_management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gg.assets.assets_management.user.User;
import com.gg.assets.assets_management.user.UserRepository;

@Configuration
public class SeedDatabase {
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) throws Exception {
        User user1 = new User("user1");
        User user2 = new User("user2");
        userRepository.save(user1);
        userRepository.save(user2);

        return args -> {
            System.out.println("Seeding done");
        };
    }

}
