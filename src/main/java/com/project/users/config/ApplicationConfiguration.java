package com.project.users.config;

import com.project.users.domain.enums.UserRoleCodeEnum;
import com.project.users.domain.enums.UserRoleEnum;
import com.project.users.domain.models.User;
import com.project.users.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Data
@AllArgsConstructor
@Configuration
public class ApplicationConfiguration {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner commandLineRunner () {
        return args -> {
            Optional<User> optionalUser = userRepository.findByEmail("admin@example.com");
            if (optionalUser.isEmpty()) {
                var user = User.builder()
                    .firstName("ADMIN")
                    .lastName("ADMIN")
                    .email("admin@example.com")
                    .userType(new UserRoleEnum(UserRoleCodeEnum.ADMIN.getValue()))
                    .password(passwordEncoder.encode("adminadmin"))
                    .build();
                userRepository.save(user);
            }
        };
    }

}
