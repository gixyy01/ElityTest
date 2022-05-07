package fr.gixy.pets;

import org.bukkit.Location;
import org.bukkit.entity.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Pet {

    protected Entity petEntity;
    protected static Map<UUID, Pet> pets = new HashMap<>();



    public abstract void spawnAnimal(Location location, Player player);




    public void setCustomName(String name) {

        petEntity.setCustomName(name);
    }

    public abstract void jump();


    public abstract void broadcastSound();

    public static Map<UUID, Pet> getPets() {
        return pets;
    }

    public Entity getPetEntity() {
        return petEntity;
    }
}

