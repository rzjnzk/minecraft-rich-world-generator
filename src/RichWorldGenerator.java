package me.rzjnzk.richworldgenerator;

// Dependencies.
import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.generator.ChunkGenerator;

// Project.
import me.rzjnzk.richworldgenerator.Generator;

public class RichWorldGenerator extends JavaPlugin
{
    Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable()
    {
        // Bukkit.getServer().getLogger().info("RichWorldGenerator enabled.");
        log.info("RichWorldGenerator enabled.");
    }

    @Override
    public void onDisable()
    {
        // Bukkit.getServer().getLogger().info("RichWorldGenerator disabled.");
        log.info("RichWorldGenerator disabled.");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("hello") && sender instanceof Player)
        {
            Player player = (Player) sender;
            player.sendMessage("world");
            return true;
        }

        return false;
    }

    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id)
    {
        return new Generator();
    }
}
