package tomiboul.projet.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Drinks {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private varietyOfDrinksEnum typeOfDrink;
    private int numberOfThisDrink;

    @ManyToOne
    @JoinColumn(name = "commands_id")
    private Commands command;

    public Drinks(String name, double price, varietyOfDrinksEnum typeOfDrink,  int numberOfThisDrink) {
        assert price >= 0;
        assert typeOfDrink != null;
        assert numberOfThisDrink >= 0;

        this.name = name;
        this.price = price;
        this.typeOfDrink = typeOfDrink;
        this.numberOfThisDrink = numberOfThisDrink;
    }

    private final String passwordsToChangePrice = "I can change my password";

    public Drinks() {

    }


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
    public int getNumberOfThisDrink() {
        return numberOfThisDrink;
    }
    public void setNumberOfThisDrink(int numberOfThisDrink) {
        assert numberOfThisDrink >= 0;
        this.numberOfThisDrink = numberOfThisDrink;
    }

    public void setCommand(Commands command) {
        this.command = command;
    }

}
