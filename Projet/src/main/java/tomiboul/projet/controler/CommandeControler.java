package tomiboul.projet.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tomiboul.projet.Services.ServiceDrinks;
import tomiboul.projet.entity.Commands;
import tomiboul.projet.entity.Drinks;
import tomiboul.projet.factory.ProductsFactory;
import tomiboul.projet.repositories.CommandsRepository;

@Controller
@RequestMapping("/commands")
public class CommandeControler {

    @Autowired
    private   CommandsRepository commandeRepository;

    @Autowired
    private ServiceDrinks serviceDrinks;

    public boolean creationCommande = false;

    public CommandeControler(CommandsRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }


    @GetMapping("")
    public String commands() {
        return "commands";
    }

    @GetMapping("/createCommand")
    public String createCommandView() {
        return "createCommand";
    }
    @PostMapping("/createCommand")
    public String createCommand(@RequestParam String name, @RequestParam String description) { //@RequestParam String name, @RequestParam String description
        Commands commande = new Commands();
        commande.setName(name);
        commande.setDescription(description);
        commandeRepository.save(commande);
        return "redirect:/commands/createCommand/" + commande.getId();
    }



    @GetMapping("/createCommand/{id}")
    public String modifyCommand(@PathVariable Long id, Model model) {
        Commands commande = commandeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Command not found : " +id ));
        model.addAttribute("commande", commande);
        return "addDrinks";
    }

    @PostMapping("/createCommand/{id}")
    public String addDrinks(@RequestParam  String name,
                            @RequestParam double price,
                            @RequestParam Drinks.varietyOfDrinksEnum typeOfDrink,
                            @PathVariable Long id){
        Drinks drink = serviceDrinks.addDrink(name, price, typeOfDrink);
        Commands commande = commandeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Command not found : " +id ));
        commande.addDrinks(drink);
        commandeRepository.save(commande);
        return "redirect:/commands/createCommand/" + id; //"redirect:/commands/createCommand/" + id
    }



}
