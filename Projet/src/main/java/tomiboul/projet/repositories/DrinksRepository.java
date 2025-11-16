package tomiboul.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tomiboul.projet.entity.Drinks;

import java.util.Optional;

public interface DrinksRepository extends JpaRepository<Drinks, Long>{
    Optional<Drinks> findByName(String name);

}
