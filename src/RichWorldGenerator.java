package me.rzjnzk.richworldgenerator;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.World;
import java.util.Random;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public final class RichWorldGenerator extends JavaPlugin
{
    public static Logger log = Logger.getLogger("Minecraft");

    public void onLoad() 
    {
        log.info("RichWorldGenerator loaded.");
    }

    public void onEnable()
    {
        // Bukkit.getServer().getLogger().info("RichWorldGenerator enabled.");
        log.info("RichWorldGenerator enabled.");
    }

    public void onDisable()
    {
        // Bukkit.getServer().getLogger().info("RichWorldGenerator disabled.");
        log.info("RichWorldGenerator disabled.");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if(commandLabel.equalsIgnoreCase("hello") && sender instanceof Player)
        {
            Player player = (Player) sender;
            getServer().broadcastMessage("world");
            return true;
        }

        return false;
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) 
    {
        return new CustomChunkGenerator();
    }
}






