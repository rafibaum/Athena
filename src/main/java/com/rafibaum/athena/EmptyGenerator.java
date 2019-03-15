package com.rafibaum.athena;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmptyGenerator extends ChunkGenerator {

  @Override
  public List<BlockPopulator> getDefaultPopulators(World world) {
    return new ArrayList<>();
  }

  @Override
  public boolean canSpawn(World world, int x, int z) {
    return true;
  }

  @Override
  public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
    return Bukkit.createChunkData(world);
  }
}
