package tomiboul.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tomiboul.projet.entity.Meal;

public interface MealRepository extends JpaRepository<Meal, Long>{
}
