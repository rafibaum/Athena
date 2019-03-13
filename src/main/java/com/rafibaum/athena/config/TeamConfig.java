package com.rafibaum.athena.config;

import com.rafibaum.athena.Position;
import org.bukkit.Color;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TeamConfig {

  private String name;
  private Color color;
  private Position spawnLocation;
  private Inventory spawnItems;

  public TeamConfig(String name, Color color, Position spawnLocation, Inventory spawnItems) {
    this.name = name;
    this.color = color;
    this.spawnLocation = spawnLocation;
    this.spawnItems = spawnItems;
  }

  public TeamConfig() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Position getSpawnLocation() {
    return spawnLocation;
  }

  public void setSpawnLocation(Position spawnLocation) {
    this.spawnLocation = spawnLocation;
  }

  public Inventory getSpawnItems() {
    return spawnItems;
  }

  public void setSpawnItems(Inventory spawnItems) {
    this.spawnItems = spawnItems;
  }
}
