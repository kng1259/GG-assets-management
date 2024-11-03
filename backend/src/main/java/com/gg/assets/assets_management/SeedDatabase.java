package com.gg.assets.assets_management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gg.assets.assets_management.department.Department;
import com.gg.assets.assets_management.department.DepartmentRepository;
import com.gg.assets.assets_management.user.User;
import com.gg.assets.assets_management.user.UserRepository;

@Configuration
public class SeedDatabase {
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, DepartmentRepository departmentRepository)
            throws Exception {
        Department department1 = new Department("department1");
        Department department2 = new Department("department2");
        User user1 = new User("user1", "a@g.c", "123", department1);
        User user2 = new User("user2", "b@g.c", "123", department2);
        departmentRepository.save(department1);
        departmentRepository.save(department2);
        userRepository.save(user1);
        userRepository.save(user2);

        return args -> {
            System.out.println("Seeding done");
        };
    }

}
