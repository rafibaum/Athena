package com.rafibaum.athena;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;

public class Match {

  private final Location spawnLocation;
  private final World world;

  public Match(MapConfig config) {
    this(config.getDirName(), config.getSpawnLocation());
  }

  public Match(String dirName, Position spawnLocation) {
    World world = Bukkit.createWorld(new WorldCreator(dirName));
    this.world = world;

    world.setAutoSave(false);
    world.setStorm(false);

    this.spawnLocation = spawnLocation.getLocation(world);
  }

  public Location getSpawnLocation() {
    return spawnLocation;
  }

  public World getWorld() {
    return world;
  }

  public void close() {
    Bukkit.unloadWorld(world, false);
  }
}
