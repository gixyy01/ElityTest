package fr.gixy;

import fr.gixy.commands.CommandPet;
import fr.gixy.commands.CommandZoo;
import fr.gixy.listeners.EntityDeath;
import fr.gixy.listeners.EntityInteractEvents;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {


    @Override
    public void onEnable() {

        getCommand("zoo").setExecutor(new CommandZoo(this));
        getCommand("pet").setExecutor(new CommandPet(this));
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new EntityDeath(this), this);
        pm.registerEvents(new EntityInteractEvents(this),this);

    }

    @Override
    public void onDisable() {


    }



}
