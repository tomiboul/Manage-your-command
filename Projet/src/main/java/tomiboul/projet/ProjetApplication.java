package tomiboul.projet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tomiboul.projet.Services.UserService;
import tomiboul.projet.entity.Role;

import java.util.Set;

@SpringBootApplication
public class ProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserService userService) {
        return args -> {
            if (!userService.anyUserExists()) {
                userService.register("admin", "admin123", Set.of(Role.ROLE_ADMIN, Role.ROLE_USER));
                System.out.println("Admin initial créé : login=admin / password=admin123");
            }
        };
    }

}
