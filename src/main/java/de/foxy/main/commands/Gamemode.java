package de.foxy.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Gamemode implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) && args.length < 2) {
            sender.sendMessage("§6Only Players can use this Command!");
            return false;
        }

        if (args.length == 2) {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            
            if (target == null) {
                sender.sendMessage("§cThe Player isn't online or doesn't exists!");
                return false;
            }
            
            GameMode gm = GameMode.SURVIVAL;

            if (args[1].equalsIgnoreCase("1")) {
                gm = GameMode.CREATIVE;

            } else if (args[1].equalsIgnoreCase("0")) {
                gm = GameMode.SURVIVAL;
                
            } else if (args[1].equalsIgnoreCase("2")) {
                gm = GameMode.ADVENTURE;

            } else if (args[1].equalsIgnoreCase("3")) {
                gm = GameMode.SPECTATOR;

            } else if (args[1].equalsIgnoreCase("creative")) {
                gm = GameMode.CREATIVE;

            } else if (args[1].equalsIgnoreCase("survival")) {
                gm = GameMode.SURVIVAL;

            } else if (args[1].equalsIgnoreCase("adventure")) {
                gm = GameMode.ADVENTURE;

            } else if (args[1].equalsIgnoreCase("spectator")) {
                gm = GameMode.SPECTATOR;

            } else {
                sender.sendMessage("§cThe Gamemode doesn't exist!");
                return false;
            }

            if (target.getGameMode() == gm) {
                sender.sendMessage("§cThe Player §f" + target.getName() + "§c is already in §f" + gm.name());
                return false;
            }

            target.setGameMode(gm);
            target.sendMessage("§aYour gamemode is now §f" + gm.name());
            sender.sendMessage("§aThe Player §f" + target.getName() + "§a has now the Gamemode §f" + gm.name());
            return false;
        }

        if (args.length == 1) {
            Player player = (Player) sender;

            GameMode gm;

            if (args[0].equalsIgnoreCase("1")) {
                gm = GameMode.CREATIVE;

            } else if (args[0].equalsIgnoreCase("0")) {
                gm = GameMode.SURVIVAL;

            } else if (args[0].equalsIgnoreCase("2")) {
                gm = GameMode.ADVENTURE;

            } else if (args[0].equalsIgnoreCase("3")) {
                gm = GameMode.SPECTATOR;

            } else if (args[0].equalsIgnoreCase("creative")) {
                gm = GameMode.CREATIVE;

            } else if (args[0].equalsIgnoreCase("survival")) {
                gm = GameMode.SURVIVAL;

            } else if (args[0].equalsIgnoreCase("adventure")) {
                gm = GameMode.ADVENTURE;

            } else if (args[0].equalsIgnoreCase("spectator")) {
                gm = GameMode.SPECTATOR;

            } else {
                player.sendMessage("§cThe Gamemode doesn't exist!");
                return false;
            }
            
            if (player.getGameMode() == gm) {
                player.sendMessage("§cYou are already in §f" + gm.name());
                return false;
            }

            player.setGameMode(gm);
            player.sendMessage("§aYour gamemode is now §f" + gm.name());
            return false;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1){
            List<String> arguments = new ArrayList<>();
            arguments.add("creative");
            arguments.add("survival");
            arguments.add("adventure");
            arguments.add("spectator");

            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);

            for (int i = 0; i < players.length; i++){
                arguments.add(players[i].getName());
            }

            return arguments;
        }

        if (args.length == 2) {
            List<String> arguments = new ArrayList<>();
            arguments.add("creative");
            arguments.add("survival");
            arguments.add("adventure");
            arguments.add("spectator");

            return arguments;
        }
        return null;
    }
}
