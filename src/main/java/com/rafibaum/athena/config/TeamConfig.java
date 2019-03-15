package com.rafibaum.athena.config;

import com.rafibaum.athena.Position;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class TeamConfig {

  private String name;
  private ChatColor color;
  private Position spawnPosition;
  private Inventory spawnItems;

  public TeamConfig(String name, ChatColor color, Position spawnPosition, Inventory spawnItems) {
    this.name = name;
    this.color = color;
    this.spawnPosition = spawnPosition;
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

  public ChatColor getColor() {
    return color;
  }

  public void setColor(ChatColor color) {
    this.color = color;
  }

  public Position getSpawnPosition() {
    return spawnPosition;
  }

  public void setSpawnPosition(Position spawnPosition) {
    this.spawnPosition = spawnPosition;
  }

  public Inventory getSpawnItems() {
    return spawnItems;
  }

  public void setSpawnItems(Inventory spawnItems) {
    this.spawnItems = spawnItems;
  }
}
