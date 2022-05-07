package fr.gixy.listeners;

import fr.gixy.Main;
import fr.gixy.pets.Pet;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Map;
import java.util.UUID;

public class EntityDeath implements Listener {

    private final Main main;

    public EntityDeath(Main main) {

        this.main = main;


    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        Entity entity = event.getEntity();

        for (Map.Entry<UUID, Pet> e : Pet.getPets().entrySet()) {

            if (e.getValue().getPetEntity().getEntityId() == entity.getEntityId()) {


                Pet.getPets().remove(e.getKey());
            }
        }


    }

}
