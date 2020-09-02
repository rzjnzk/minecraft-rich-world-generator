package me.rzjnzk.richworldgenerator;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.Plugin;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.World;
import java.util.Random;
import org.bukkit.util.noise.SimplexOctaveGenerator;
import org.bukkit.Material;

public class CustomChunkGenerator extends ChunkGenerator 
{
    int currentHeight = 50;

    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) 
    {
    	SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        ChunkData chunk = createChunkData(world);
        generator.setScale(0.005D);

        for (int X = 0; X < 16; X++)
        {
            for (int Z = 0; Z < 16; Z++) 
            {
                currentHeight = (int) (generator.noise(chunkX * 16 + X, chunkZ * 16 + Z, 0.5D, 0.5D) * 15D + 50D);
                chunk.setBlock(X, currentHeight, Z, Material.GRASS);
                chunk.setBlock(X, currentHeight-1, Z, Material.DIRT);
                
                for (int i = currentHeight-2; i > 0; i--)
                {
                    chunk.setBlock(X, i, Z, Material.STONE);
                }

                chunk.setBlock(X, 0, Z, Material.BEDROCK);
            }
        }
        
        return chunk;
    }
}