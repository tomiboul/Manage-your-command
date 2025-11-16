package tomiboul.projet.factory;

import org.springframework.stereotype.Component;
import tomiboul.projet.entity.Drinks;
import tomiboul.projet.entity.Meal;

@Component
public class ProductsFactory {

    public Drinks createDrink(String name, double price, Drinks.varietyOfDrinksEnum typeOfDrink) {
        return new Drinks(name, price, typeOfDrink);
    }

    public Meal createMeal(String name, double price, Meal.typeOfMealEnum typeOfMeal, boolean vegatarian) {
        return new Meal(name, price, typeOfMeal, vegatarian);
    }
}
