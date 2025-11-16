package tomiboul.projet.factory;

import org.springframework.stereotype.Component;
import tomiboul.projet.entity.Drinks;
import tomiboul.projet.entity.Meal;

@Component
public class ProductsFactory {

    ProductsFactory(){}
    public Drinks createDrink(String name, double price, Drinks.varietyOfDrinksEnum typeOfDrink, int numberOfThisDrink) {
        return new Drinks(name, price, typeOfDrink, numberOfThisDrink);
    }

    public Meal createMeal(String name, double price, Meal.typeOfMealEnum typeOfMeal, boolean vegatarian) {
        return new Meal(name, price, typeOfMeal, vegatarian);
    }
}
