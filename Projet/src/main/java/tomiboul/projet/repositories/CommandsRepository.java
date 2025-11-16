package tomiboul.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tomiboul.projet.entity.Commands;

public interface CommandsRepository extends JpaRepository<Commands, Long> {
}
