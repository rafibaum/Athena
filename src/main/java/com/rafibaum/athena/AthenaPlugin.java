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

  private static Arena currentArena;
  private static List<Player> spectators;

  @Override
  public void onDisable() {
    currentArena.close();
  }

  @Override
  public void onEnable() {
    currentArena = new RaceForVictory3();
    currentArena.init();

    spectators = new ArrayList<Player>();

    registerEvents();
  }

  public void registerEvents() {
    PluginManager pm = getServer().getPluginManager();

    pm.registerEvents(new JoinHandler(), this);
    pm.registerEvents(new WeatherHandler(), this);
    pm.registerEvents(new LeaveHandler(), this);
    pm.registerEvents(new SpectatorHandler(), this);
    pm.registerEvents(new IgniteEvent(), this);
    pm.registerEvents(new IgniteHandler(), this);
    pm.registerEvents(new CreatureSpawnHandler(), this);
  }

  public static Location getJoinLocation() {
    return currentArena.getSpawnLocation();
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
