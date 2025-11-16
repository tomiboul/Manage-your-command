package tomiboul.projet.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tomiboul.projet.Services.ServiceDrinks;
import tomiboul.projet.entity.Commands;
import tomiboul.projet.entity.Drinks;
import tomiboul.projet.repositories.CommandsRepository;
import tomiboul.projet.repositories.DrinksRepository;

import java.util.Optional;

@Controller
@RequestMapping("/Drinks")
public class DrinksControler {
    private DrinksRepository drinksRepository;

    private CommandsRepository commandeRepository;

    @GetMapping("")
    public String commands() {
        return "drinks";
    }

//    @PostMapping("/addDrinks")
//    public String addDrinks(@PathVariable String name,
//                            @PathVariable double price,
//                            @PathVariable Drinks.varietyOfDrinksEnum typeOfDrink,
//                            Long id){
//        Drinks drink = ServiceDrinks.addDrink(name, price, typeOfDrink);
//        Commands commande = commandeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Command not found : " +id ));
//        commande.addDrink(drink);
//        commandeRepository.save(commande);
//        return "redirect:/commands/createCommand/" + id;
//    }
}
