package tomiboul.projet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Drinks {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private static varietyOfDrinksEnum typeOfDrink;

    public Drinks() {}

    public Drinks(String name, double price, varietyOfDrinksEnum typeOfDrink) {
        this.name = name;
        this.price = price;
        this.typeOfDrink = typeOfDrink;
    }

    private static final String passwordsToChangePrice = "I can change my password";



    public enum varietyOfDrinksEnum{
        SOFT,
        ALCOOL,
        BEER,
        HOT_DRINKS,
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price, String password) {
        if (password.equals(passwordsToChangePrice)) {
            this.price = price;
        }
        else {
            System.out.println("Passwords do not match");
        }
    }
    public varietyOfDrinksEnum getType() {
        return typeOfDrink;
    }
    public void setType(varietyOfDrinksEnum typeOfDrink) {
        this.typeOfDrink = typeOfDrink;
    }


}
