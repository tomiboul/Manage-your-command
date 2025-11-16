package tomiboul.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tomiboul.projet.entity.Drinks;

public interface DrinksRepository extends JpaRepository<Drinks, Long>{
}
