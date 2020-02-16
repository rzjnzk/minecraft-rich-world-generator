package me.rzjnzk.richworldgenerator;

// Dependencies.
import java.util.Random;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

public class Generator extends ChunkGenerator
{
    public byte[][] generateBlockSections(World world, Random random, int chunkX, int chunkZ, BiomeGrid biomeGrid)
    {
        byte[][] result = new byte[world.getMaxHeight() / 16][];
        return result;
    }
}
