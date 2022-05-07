package fr.gixy.pets;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class CowPet extends Pet {
    @Override
    public void spawnAnimal(Location location, Player player) {

        this.petEntity = player.getWorld().spawn(player.getLocation(), Cow.class);

    }

    @Override
    public void jump() {

        this.petEntity.setVelocity(new Vector(0, 0.5f, 0));


    }

    @Override
    public void broadcastSound() {

        Bukkit.broadcastMessage(ChatColor.GREEN+petEntity.getCustomName() + " MEUHHHHHH");


    }
}
