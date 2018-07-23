package com.homify.homify;

import com.homify.homify.business.Professional;
import com.homify.homify.server.reference.Professional.ProfessionalJDO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomifyApplication.class, args);
    }

    @Bean
    protected CommandLineRunner init(final ProfessionalJDO userRepository) {

        return args -> {
            Professional user = new Professional();
            user.setUserName("admin");
            user.setPassword("admin");
            user.setFirstName("Administrator");
            user.setEmail("admin@javahelps.com");
            userRepository.createProfessional(user);

        };
    }
}
