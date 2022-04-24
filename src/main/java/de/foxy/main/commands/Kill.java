package de.foxy.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Kill implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) && args.length == 0) {
            sender.sendMessage("§6Only Players can use this Command!");
            return false;
        }

        if (args.length == 0) {
            Player p = (Player) sender;
            p.setHealth(0);

            return false;
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("*")) {
                Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                Bukkit.getServer().getOnlinePlayers().toArray(players);

                for (int i=0; i < players.length; i++) {
                    players[i].setHealth(0);
                }
                return false;
            }

            Player t = Bukkit.getServer().getPlayer(args[0]);

            if (t == null) {
                sender.sendMessage("§cThe Player isn't online or doesn't exist!");
                return false;
            }

            t.setHealth(0);
            return false;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> arguments = new ArrayList<>();
            arguments.add("*");

            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);

            for (int i = 0; i < players.length; i++) {
                arguments.add(players[i].getName());
            }

            return arguments;
        }
        return null;
    }
}
