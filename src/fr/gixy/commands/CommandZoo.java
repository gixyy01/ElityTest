package fr.gixy.commands;

import fr.gixy.Main;
import fr.gixy.pets.ChickenPet;
import fr.gixy.pets.CowPet;
import fr.gixy.pets.Pet;
import fr.gixy.pets.SheepPet;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandZoo implements CommandExecutor {

    final private Main main;

    public CommandZoo(Main main) {

        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {

            Player player = (Player) sender;
            Pet pet = Pet.getPets().get(player.getUniqueId());

            if (pet != null) {

                player.sendMessage("Vous avez déjà un pet en vie !");
                return true;


            }

            if (args.length != 1) {

                player.sendMessage("Syntaxe correcte :" + ChatColor.RED + " /zoo [mouton,cochon,vache]");

                return true;
            }
            if (args[0].equalsIgnoreCase("poulet")) {

                pet = new ChickenPet();


            } else if (args[0].equalsIgnoreCase("vache")) {

                pet = new CowPet();

            } else if (args[0].equalsIgnoreCase("mouton")) {

                pet = new SheepPet();


            }

            pet.spawnAnimal(player.getLocation(), player);

            Pet.getPets().put(player.getUniqueId(), pet);

        }

        return false;
    }
}
