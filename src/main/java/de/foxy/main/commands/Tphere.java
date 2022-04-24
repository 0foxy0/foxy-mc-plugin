package de.foxy.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tphere implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§6Only Players can use this Command!");
            return false;
        }

        if (args.length != 1) {
            sender.sendMessage("§cUse /tphere <player>");
            return false;
        }

        Player p = (Player) sender;
        Player t = Bukkit.getServer().getPlayer(args[0]);

        if (t == null) {
            sender.sendMessage("§cThe Player isn't online or doesn't exist!");
            return false;
        }

        Location pLoc = p.getLocation();
        t.teleport(pLoc);
        return false;
    }
}
