package fr.gixy.listeners;

import fr.gixy.Main;
import fr.gixy.pets.Pet;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.Map;
import java.util.UUID;

public class EntityInteractEvents implements Listener {

    final private Main main;

    public EntityInteractEvents(Main main) {

        this.main = main;
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent event) {

        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();


        for (Map.Entry<UUID, Pet> e : Pet.getPets().entrySet()) {

            if (e.getValue().getPetEntity().getEntityId() == entity.getEntityId()){

                entity.setPassenger(player);
            }


        }


    }
}
