package tomiboul.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tomiboul.projet.entity.Commands;

import java.util.Optional;

public interface CommandsRepository extends JpaRepository<Commands, Long> {
    Optional<Commands> findByName(String name);
}
