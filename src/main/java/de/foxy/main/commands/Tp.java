package de.foxy.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2) {
            Player t = Bukkit.getServer().getPlayer(args[0]);
            Player p = Bukkit.getServer().getPlayer(args[1]);

            if (t == null || p == null) {
                sender.sendMessage("§cOne of the Players isn't online or doesn't exist!");
                return false;
            }

            Location pLoc = p.getLocation();
            t.teleport(pLoc);
            return false;

        } else {
            sender.sendMessage("§cUse /tp <playerToTp> <player>");
        }
        return false;
    }
}
