package com.rafibaum.athena;

import com.rafibaum.athena.events.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class AthenaPlugin extends JavaPlugin {

  private static Match currentMatch;
  private static List<Player> spectators;

  @Override
  public void onDisable() {
    currentMatch.close();
  }

  @Override
  public void onEnable() {
    MapConfig rfv3 = new MapConfig("raceforvictory3",
        new Position(44.5, 8, 0.5, -90.0f, 0.0f));
    currentMatch = new Match(rfv3);

    spectators = new ArrayList<Player>();

    registerEvents();
  }

  public void registerEvents() {
    PluginManager pm = getServer().getPluginManager();

    pm.registerEvents(new JoinHandler(), this);
    pm.registerEvents(new WeatherHandler(), this);
    pm.registerEvents(new LeaveHandler(), this);
    pm.registerEvents(new SpectatorHandler(), this);
    pm.registerEvents(new IgniteHandler(), this);
    pm.registerEvents(new CreatureSpawnHandler(), this);
  }

  public static Location getJoinLocation() {
    return currentMatch.getSpawnLocation();
  }

  public static void addSpectator(Player spectator) {
    spectators.add(spectator);
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (!isSpectator(player)) {
        player.hidePlayer(spectator);
      }
    }
  }

  public static boolean isSpectator(Player spectator) {
    return spectators.contains(spectator);
  }

  public static void removeSpectator(Player spectator) {
    spectators.remove(spectator);

    for (Player player : Bukkit.getOnlinePlayers()) {
      if (!isSpectator(player)) {
        player.showPlayer(spectator);
      }
    }
  }

}
