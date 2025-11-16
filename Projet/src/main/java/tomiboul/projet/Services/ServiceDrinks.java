package tomiboul.projet.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tomiboul.projet.entity.Drinks;
import tomiboul.projet.repositories.DrinksRepository;

import java.util.Optional;

@Service
public class ServiceDrinks {

    @Autowired
    private DrinksRepository drinksRepository;

    public Drinks addDrink(String name, double price, Drinks.varietyOfDrinksEnum typeOfDrink) {
        Optional<Drinks> optionalDrink = drinksRepository.findByName(name).filter(prices -> prices.getPrice() == price);
        Drinks drink;
        if (optionalDrink.isPresent()) {
            drink = optionalDrink.get();
            drink.setPrice(price,"I can change my password");
            drink.setNumberOfThisDrink(drink.getNumberOfThisDrink() + 1);
        }else {
            drink = new Drinks();
            drink.setName(name);
            drink.setPrice(price,"I can change my password");
            drink.setType(typeOfDrink);
            drink.setNumberOfThisDrink(1);
        }
        //drinksRepository.save(drink);
        return drink;
    }
}
