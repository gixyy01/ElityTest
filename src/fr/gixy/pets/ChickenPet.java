package fr.gixy.pets;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ChickenPet extends Pet {
    @Override
    public void spawnAnimal(Location location, Player player) {

        this.petEntity = player.getWorld().spawn(player.getLocation(), Chicken.class);


    }

    @Override
    public void jump() {

        this.petEntity.setVelocity(new Vector(0,5f,0));

    }

    @Override
    public void broadcastSound() {
        Bukkit.broadcastMessage(ChatColor.GREEN+petEntity.getCustomName() + " COCOTTTT");


    }
}
