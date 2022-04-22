package de.foxy.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player) && args.length == 0) {
            sender.sendMessage("§6Only Players can use this Command!");
            return false;
        }

        if (args.length == 1) {
            Player target = Bukkit.getServer().getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage("§cThe Player isn't online or doesn't exists!");
                return false;
            }

            if (target.getAllowFlight() == true) {
                target.setAllowFlight(false);
                target.setFlying(false);
                target.sendMessage("§cYou are now not anymore in Flymode!");
                sender.sendMessage("§cThe Player " + target.getName() + " is now not anymore in Flymode!");
                return false;
            }

            target.setAllowFlight(true);
            target.setFlying(true);
            sender.sendMessage("§aThe Player " + target.getName() + " is now in Flymode!");
            target.sendMessage("§aYou are now in Flymode!");
            return false;
        }

        Player player = (Player) sender;

        if (player.getAllowFlight() == true) {
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage("§cYou are now not anymore in Flymode!");
            return false;
        }

        player.setAllowFlight(true);
        player.setFlying(true);
        player.sendTitle("§6Flymode", "§7↳ §faktiviert");
        player.sendMessage("§aYou are now in Flymode!");
        return false;
    }
}
