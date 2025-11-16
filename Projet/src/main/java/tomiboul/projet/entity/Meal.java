package tomiboul.projet.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private static typeOfMealEnum typeOfMeal;

    public Meal() {}

    public Meal(String name, double price,  typeOfMealEnum typeOfMeal) {
        this.name = name;
        this.price = price;
        this.typeOfMeal = typeOfMeal;
    }

    private static final String passwordsToChangePrice = "I can change my password";
    private enum typeOfMealEnum{
        STARTER,
        MAIN_COURSE,
        DESSERT
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
    public static typeOfMealEnum getTypeOfMeal() {
        return typeOfMeal;
    }
    public void setTypeOfMeal(typeOfMealEnum typeOfMeal) {
        this.typeOfMeal = typeOfMeal;
    }
}
