package com.rafibaum.athena;

import com.rafibaum.athena.config.TeamConfig;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import java.util.ArrayList;
import java.util.List;

public class Team {

  private final String name;
  private final Color color;
  private final Location spawnLocation;
  private final Inventory spawnItems;
  private final List<Player> players;

  public Team(TeamConfig config, Match match) {
    this.name = config.getName();
    this.color = config.getColor();
    this.spawnLocation = config.getSpawnLocation().getLocation(match.getWorld());
    this.spawnItems = config.getSpawnItems();
    this.players = new ArrayList<>();
  }

  public void respawnPlayer(Player player) {
    player.setGameMode(GameMode.SURVIVAL);
    player.getInventory().setContents(spawnItems.getContents());
  }

  public String getName() {
    return name;
  }

  public Color getColor() {
    return color;
  }

  public Location getSpawnLocation() {
    return spawnLocation;
  }

  public Inventory getSpawnItems() {
    return spawnItems;
  }


  public void addPlayer(Player player) {
    players.add(player);
  }

  public boolean isOnTeam(Player player) {
    return players.contains(player);
  }

  public void removePlayer(Player player) {
    players.remove(player);
  }

  public int size() {
    return players.size();
  }

}
