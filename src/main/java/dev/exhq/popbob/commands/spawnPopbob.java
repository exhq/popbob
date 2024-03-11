package dev.exhq.popbob.commands;

import dev.exhq.popbob.Popbob;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class spawnPopbob implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        new BukkitRunnable() {
            int index = 0;

            @Override
            public void run() {
                if (index < Material.values().length) {
                    Material material = Material.values()[index];
                    commandSender.sendMessage(material.name());
                    ItemStack itemStack = new ItemStack(material, 64);
                    for (int i = 0; i < 5; i++) {
                        ((Player) commandSender).getWorld().dropItem(((Player) commandSender).getLocation().add(0,1.2,0), itemStack).setVelocity(((Player) commandSender).getLocation().getDirection().normalize().multiply(0.3));
                    }
                    index++;
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(Popbob.getinstance(), 1L, 1L);
        return true;
    }
}
