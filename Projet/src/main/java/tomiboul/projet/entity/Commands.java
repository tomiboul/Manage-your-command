package tomiboul.projet.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Commands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "command", cascade = CascadeType.ALL)
    private List<Meal> listMeals = new ArrayList<>();

    @OneToMany(mappedBy = "command", cascade = CascadeType.ALL)
    private List<Drinks> listDrinks= new ArrayList<>();

    public  Commands() {}

    public Commands(String name, String description,  ArrayList<Meal> listMeals, ArrayList<Drinks> listDrinks) {
        this.name = name;
        this.description = description;
        this.listMeals = listMeals;
        this.listDrinks = listDrinks;
    }

    private final String passwordsToChangePrice = "I can change my password";


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
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Meal> getListMeals() {
        return listMeals;
    }
    public void setListMeals(ArrayList<Meal> listMeals, String password) {
        if (password.equals(passwordsToChangePrice)) {
            this.listMeals = listMeals;        }
        else {
            System.out.println("Passwords do not match");
        }
    }
    public List<Drinks> getListDrinks() {
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
    public void addDrinks(Drinks drink) {
        drink.setCommand(this);
        listDrinks.add(drink);
    }
}

