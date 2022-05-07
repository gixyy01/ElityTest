package fr.gixy.commands;

import fr.gixy.Main;
import fr.gixy.pets.Pet;
import fr.gixy.pets.SheepPet;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandPet implements CommandExecutor {

    final private Main main;

    public CommandPet(Main main) {

        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {

            Player player = (Player) sender;
            if (args.length < 1) {
                player.sendMessage(ChatColor.GREEN + "Vous devez mettre au moins un argument pour valider la commande"
                        + ChatColor.YELLOW + "-> /pet help ");
                return true;
            }

            if (args.length > 2) {

                player.sendMessage("Votre commande comporte trop d'arguments !");
                return true;
            }

            Pet pet = Pet.getPets().get(player.getUniqueId());

            if (pet == null) {

                player.sendMessage(ChatColor.RED+"Vous avez pas de pet");
                return true;
            }


            if (args[0].equalsIgnoreCase("name")) {

                String name = args[1];
                pet.setCustomName(name);
                player.sendMessage(ChatColor.GREEN + "Le nouveau nom de votre pet est : " + ChatColor.YELLOW + name);

            } else if (args[0].equalsIgnoreCase("jump")) {

                pet.jump();

            } else if (args[0].equalsIgnoreCase("sound")) {

                pet.broadcastSound();


            } else if (args[0].equalsIgnoreCase("color")) {
                if (pet instanceof SheepPet) {
                    ((SheepPet) pet).changeColor();
                }


            } else if (args[0].equalsIgnoreCase("help")) {

                player.sendMessage(ChatColor.YELLOW + "Liste des arguments :");
                player.sendMessage("");
                player.sendMessage("§m------------------------------------");
                player.sendMessage("");
                player.sendMessage("/pet name");
                player.sendMessage("/pet jump");
                player.sendMessage("/pet sound");
                player.sendMessage("/pet color");
                player.sendMessage("");
                player.sendMessage("§m------------------------------------");
            }


        }
        return false;
    }
}