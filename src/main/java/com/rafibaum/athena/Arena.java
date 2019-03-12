package com.rafibaum.athena;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;

public class Arena {

  private final String dirName;
  private final Position spawnLocation;
  private World world;

  public Arena(String dirName, Position spawnLocation) {
    this.dirName = dirName;
    this.spawnLocation = spawnLocation;
  }

  public Location getSpawnLocation() {
    return spawnLocation.getLocation(world);
  }

  public World getWorld() {
    return world;
  }

  public World init() {
    World world = Bukkit.createWorld(new WorldCreator(dirName));
    this.world = world;

    world.setAutoSave(false);
    world.setStorm(false);

    return world;
  }

  public void close() {
    Bukkit.unloadWorld(world, false);
    world = null;
  }
}
