package de.foxy.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
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

            if (target.getHealth() == 20 && target.getFoodLevel() == 20) {
                sender.sendMessage("§cThat Player can't be healed!");
                return false;
            }
            target.setHealth(20);
            target.setFoodLevel(20);
            target.sendMessage("§aYou got healed!");

            sender.sendMessage("§aThe Player was healed!");
            return false;
        }

        Player player = ((Player) sender).getPlayer();

        if (player.getHealth() == 20 && player.getFoodLevel() == 20) {
            player.sendMessage("§cYou can't be healed!");
            return false;
        }
        player.setHealth(20);
        player.setFoodLevel(20);
        player.sendMessage("§aYou healed yourself!");

        return false;
    }
}
