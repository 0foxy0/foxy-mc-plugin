package de.foxy.main;

import de.foxy.main.commands.Fly;
import de.foxy.main.commands.Gamemode;
import de.foxy.main.commands.Heal;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aPlugin successfully loaded!");

        getCommand("heal").setExecutor(new Heal());
        getCommand("fly").setExecutor(new Fly());
        getCommand("gamemode").setExecutor(new Gamemode());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cThe Server stopped!");

    }
}
