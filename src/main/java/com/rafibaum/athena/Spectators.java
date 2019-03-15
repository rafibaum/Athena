package com.rafibaum.athena;

import com.rafibaum.athena.config.TeamConfig;
import org.bukkit.ChatColor;
import org.bukkit.World;

public class Spectators extends Team {

  public Spectators(Position spawnPosition, World world) {
    super(getConfig(spawnPosition), world);
  }

  @Override
  public boolean isSpectators() {
    return true;
  }

  private static TeamConfig getConfig(Position spawnPosition) {
    TeamConfig config = new TeamConfig();
    config.setName("Spectator");
    config.setColor(ChatColor.AQUA);
    config.setSpawnPosition(spawnPosition);

    return config;
  }
}
