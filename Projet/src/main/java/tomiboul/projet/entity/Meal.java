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
    private static boolean vegetarian;

    public Meal() {}

    public Meal(String name, double price,  typeOfMealEnum typeOfMeal, boolean vegetarian) {
        this.name = name;
        this.price = price;
        this.typeOfMeal = typeOfMeal;
        this.vegetarian = vegetarian;
    }

    private static final String passwordsToChangePrice = "I can change my password";
    public enum typeOfMealEnum{
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
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public static typeOfMealEnum getTypeOfMeal() {
        return typeOfMeal;
    }
    public void setTypeOfMeal(typeOfMealEnum typeOfMeal) {
        this.typeOfMeal = typeOfMeal;
    }
}
