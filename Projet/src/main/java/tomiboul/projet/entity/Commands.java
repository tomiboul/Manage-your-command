package tomiboul.projet.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class Commands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private ArrayList<Meal> listMeals;
    private ArrayList<Drinks> listDrinks;

    public  Commands() {}

    public Commands(String name, String description,  ArrayList<Meal> listMeals, ArrayList<Drinks> listDrinks) {
        this.name = name;
        this.description = description;
        this.listMeals = listMeals;
        this.listDrinks = listDrinks;
    }

    private static final String passwordsToChangePrice = "I can change my password";


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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description, String password) {
        if (password.equals(passwordsToChangePrice)) {
            this.description = description;
        }
        else {
            System.out.println("Passwords do not match");
        }
    }
    public ArrayList<Meal> getListMeals() {
        return listMeals;
    }
    public void setListMeals(ArrayList<Meal> listMeals, String password) {
        if (password.equals(passwordsToChangePrice)) {
            this.listMeals = listMeals;        }
        else {
            System.out.println("Passwords do not match");
        }
    }
    public ArrayList<Drinks> getListDrinks() {
        return listDrinks;
    }
    public void setListDrinks(ArrayList<Drinks> listDrinks, String password) {
        if (password.equals(passwordsToChangePrice)) {
            this.listDrinks = listDrinks;
        }
        else {
            System.out.println("Passwords do not match");
        }
    }
}
