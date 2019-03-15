package com.rafibaum.athena;

import com.rafibaum.athena.config.TeamConfig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.Inventory;

public class Team {

  private final String name;
  private final ChatColor color;
  private final Location spawnLocation;
  private final Inventory spawnItems;

  public Team(TeamConfig config, World world) {
    this.name = config.getName();
    this.color = config.getColor();
    this.spawnLocation = config.getSpawnPosition().getLocation(world);
    this.spawnItems = config.getSpawnItems();
  }

  public String getName() {
    return name;
  }

  public ChatColor getColor() {
    return color;
  }

  public Location getSpawnLocation() {
    return spawnLocation;
  }

  public Inventory getSpawnItems() {
    return spawnItems;
  }

  public boolean isSpectators() {
    return false;
  }
}
