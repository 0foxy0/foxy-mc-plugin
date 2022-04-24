package de.foxy.main.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Time implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§6Only Players can use this Command!");
            return false;
        }

        if (args.length != 1) {
            sender.sendMessage("§cUse /time <time>");
            return false;
        }

        Player p = (Player) sender;
        World w = p.getWorld();

        if (args[0].equalsIgnoreCase("day")) {
            w.setFullTime(6000);

        } else if (args[0].equalsIgnoreCase("night")) {
            w.setFullTime(14000);

        } else {
            sender.sendMessage("§cThe Time doesn't exist!");
            return false;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1){
            List<String> arguments = new ArrayList<>();
            arguments.add("day");
            arguments.add("night");

            return arguments;
        }
        return null;
    }
}
