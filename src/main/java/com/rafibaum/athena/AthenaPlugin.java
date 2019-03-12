package com.rafibaum.athena;

import com.rafibaum.athena.events.JoinHandler;
import com.rafibaum.athena.events.WeatherHandler;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AthenaPlugin extends JavaPlugin {

  private static Arena currentArena;

  @Override
  public void onDisable() {
    currentArena.close();
  }

  @Override
  public void onEnable() {
    currentArena = new RaceForVictory3();
    currentArena.init();

    registerEvents();
  }

  public void registerEvents() {
    PluginManager pm = getServer().getPluginManager();

    pm.registerEvents(new JoinHandler(), this);
    pm.registerEvents(new WeatherHandler(), this);
  }

  public static Location getJoinLocation() {
    return currentArena.getSpawnLocation();
  }

}
