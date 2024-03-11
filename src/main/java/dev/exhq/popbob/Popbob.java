package dev.exhq.popbob;

import dev.exhq.popbob.commands.spawnPopbob;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Popbob extends JavaPlugin implements Listener {
    private static Popbob instance;
    @Override
    public void onEnable() {
        instance = this;
        this.getCommand("spawnpopbob").setExecutor(new spawnPopbob());
        getLogger().info("faggot");
    }
    public static Popbob getinstance() {
        return instance;
    }
}
