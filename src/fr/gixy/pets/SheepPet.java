package fr.gixy.pets;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.util.Vector;

import java.util.Random;

public class SheepPet extends Pet {

   private static final Random RANDOM = new Random();

    @Override
    public void spawnAnimal(Location location, Player player) {


        this.petEntity = player.getWorld().spawn(player.getLocation(), Sheep.class);


    }


    @Override
    public void jump() {

        this.petEntity.setVelocity(new Vector(0, 0.8f, 0));

    }

    @Override
    public void broadcastSound() {

        Bukkit.broadcastMessage(ChatColor.GREEN+petEntity.getCustomName() + " BEHHHHHHH");


    }

    public void changeColor() {


        DyeColor dyeColor = DyeColor.values()[RANDOM.nextInt(DyeColor.values().length)];
        ((Sheep) this.petEntity).setColor(dyeColor);


    }

}
