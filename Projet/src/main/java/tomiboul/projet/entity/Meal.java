package tomiboul.projet.entity;


import jakarta.persistence.*;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private typeOfMealEnum typeOfMeal;
    private boolean vegetarian;
    private int numberOfThisMeal;

    @ManyToOne
    @JoinColumn(name = "commands_id")
    private Commands command;

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
    public typeOfMealEnum getTypeOfMeal() {
        return typeOfMeal;
    }
    public void setTypeOfMeal(typeOfMealEnum typeOfMeal) {
        this.typeOfMeal = typeOfMeal;
    }
    public int getNumberOfThisMeal() {
        return numberOfThisMeal;
    }
    public void setNumberOfThisMeal(int numberOfThisMeal) {
        this.numberOfThisMeal = numberOfThisMeal;
    }
}
