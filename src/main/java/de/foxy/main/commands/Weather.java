package de.foxy.main.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Weather implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§6Only Players can use this Command!");
            return false;
        }

        if (args.length != 1) {
            sender.sendMessage("§cUse /weather <weather>!");
            return false;
        }

        Player p = (Player) sender;
        World w = p.getWorld();

        if (args[0].equalsIgnoreCase("clear")) {
            w.setStorm(false);
            w.setThundering(false);

        } else if (args[0].equalsIgnoreCase("rain")) {
            w.setStorm(true);

        } else if (args[0].equalsIgnoreCase("thunder")) {
            w.setThundering(true);

        } else {
            sender.sendMessage("§cThe Weather doesn't exist!");
            return false;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1){
            List<String> arguments = new ArrayList<>();
            arguments.add("clear");
            arguments.add("rain");
            arguments.add("thunder");

            return arguments;
        }
        return null;
    }
}
