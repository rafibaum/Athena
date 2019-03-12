package com.rafibaum.athena;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.util.Vector;

public class Arena {

  private final String dirName;
  private final Vector spawnCoords;
  private Location spawnLocation;
  private World world;

  public Arena(String dirName, Vector spawnCoords) {
    this.dirName = dirName;
    this.spawnCoords = spawnCoords;
  }

  public Location getSpawnLocation() {
    return spawnLocation;
  }

  public World getWorld() {
    return world;
  }

  public World init() {
    World world = Bukkit.createWorld(new WorldCreator(dirName));
    world.setAutoSave(false);
    spawnLocation = new Location(world, spawnCoords.getX(), spawnCoords.getY(), spawnCoords.getZ());
    return world;
  }

  public void close() {
    Bukkit.unloadWorld(world, false);
  }
}
