package com.rafibaum.athena;

import com.rafibaum.athena.config.MapConfig;
import com.rafibaum.athena.config.RaceForVictory3;
import com.rafibaum.athena.config.TeamConfig;
import com.rafibaum.athena.events.*;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Athena extends JavaPlugin {

  private static Map<Player, Team> teamMap;
  private static List<Team> teamList;
  private static Team spectatorTeam;
  private static Plugin plugin;

  @Override
  public void onEnable() {
    plugin = this;
    teamMap = new HashMap<>();
    teamList = new ArrayList<>();

    registerEvents();

    setupMap(new RaceForVictory3());
  }

  public static void joinTeam(Player player, Team team) {
    teamMap.remove(player);
    teamMap.put(player, team);

    if (team.isSpectators()) {
      player.setGameMode(GameMode.CREATIVE);

      for (Player other : Bukkit.getOnlinePlayers()) {
        player.showPlayer(plugin, player);

        if (!isSpectator(other)) {
          other.hidePlayer(plugin, player);
        } else {
          other.showPlayer(plugin, player);
        }
      }
    } else {
      player.setGameMode(GameMode.SURVIVAL);

      for (Player other : Bukkit.getOnlinePlayers()) {
        other.showPlayer(plugin, player);

        if (isSpectator(other)) {
          player.hidePlayer(plugin, other);
        }
      }
    }

    player.setCustomName(team.getColor() + ChatColor.stripColor(player.getDisplayName()));
    player.teleport(team.getSpawnLocation());
    if (team.getSpawnItems() != null) {
      player.getInventory().setContents(team.getSpawnItems().getContents());
    }
  }

  public static Location respawnPlayer(Player player) {
    Team team = teamMap.get(player);

    if (team.getSpawnItems() != null) {
      player.getInventory().setContents(team.getSpawnItems().getContents());
    }

    return team.getSpawnLocation();
  }

  public static void removePlayer(Player player) {
    teamMap.remove(player);
  }

  public static Team getTeam(Player player) {
    return teamMap.get(player);
  }

  public static void addSpectator(Player player) {
    joinTeam(player, spectatorTeam);
  }

  public static boolean isSpectator(Player player) {
    Team team = teamMap.get(player);

    return team != null && team.isSpectators();
  }

  private static void setupMap(MapConfig config) {
    WorldCreator emptyCreator = new WorldCreator(config.getDirName());
    emptyCreator.generator(new EmptyGenerator());
    World world = Bukkit.createWorld(emptyCreator);
    world.setAutoSave(false);
    world.setStorm(false);

    teamList.clear();
    spectatorTeam = new Spectators(config.getSpawnPosition(), world);
    teamList.add(spectatorTeam);

    for (TeamConfig teamConfig : config.getTeams()) {
      Team team = new Team(teamConfig, world);
      teamList.add(team);
    }

    teamMap.clear();

    Bukkit.getOnlinePlayers().forEach(p -> joinTeam(p, spectatorTeam));
  }

  private void registerEvents() {
    PluginManager pm = Bukkit.getPluginManager();

    pm.registerEvents(new SpectatorHandler(), this);
    pm.registerEvents(new JoinHandler(), this);
    pm.registerEvents(new LeaveHandler(), this);
    pm.registerEvents(new BlockIgniteHandler(), this);
    pm.registerEvents(new WeatherHandler(), this);
    pm.registerEvents(new RespawnHandler(), this);
    pm.registerEvents(new CreatureSpawnHandler(), this);
  }
}
