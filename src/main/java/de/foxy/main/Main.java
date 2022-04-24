package de.foxy.main;

import de.foxy.main.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aPlugin successfully loaded!");

        getCommand("heal").setExecutor(new Heal());
        getCommand("fly").setExecutor(new Fly());
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("tpo").setExecutor(new Tpo());
        getCommand("tphere").setExecutor(new Tphere());
        getCommand("tp").setExecutor(new Tp());
        getCommand("weather").setExecutor(new Weather());
        getCommand("time").setExecutor(new Time());
        getCommand("kill").setExecutor(new Kill());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cThe Server stopped!");

    }
}
