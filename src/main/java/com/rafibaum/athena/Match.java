package com.rafibaum.athena;

import com.rafibaum.athena.config.MapConfig;
import com.rafibaum.athena.config.TeamConfig;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Match {

  private final Location spawnLocation;
  private final World world;
  private final Map<Player, Team> playerTeams;
  private final Team[] teams;

  public Match(MapConfig config) {
    this(config.getDirName(), config.getSpawnLocation(), config.getTeams());
  }

  public Match(String dirName, Position spawnLocation, List<TeamConfig> teamList) {
    World world = Bukkit.createWorld(new WorldCreator(dirName));
    this.world = world;

    world.setAutoSave(false);
    world.setStorm(false);

    this.teams = new Team[teamList.size()];
    for (int i = 0; i < this.teams.length; i++) {
      this.teams[i] = new Team(teamList.get(i), this);
    }

    this.spawnLocation = spawnLocation.getLocation(world);
    this.playerTeams = new HashMap<>();
  }

  public Location getSpawnLocation() {
    return spawnLocation;
  }

  public World getWorld() {
    return world;
  }

  public Team[] getTeams() {
    return teams;
  }

  public Optional<Team> getTeam(Player player) {
    Team team = playerTeams.get(player);
    return Optional.ofNullable(team);
  }

  public void joinTeam(Player player, Team team) {
    AthenaPlugin.removeSpectator(player);
    Optional<Team> curTeam = getTeam(player);
    if (curTeam.isPresent()) {
      curTeam.get().removePlayer(player);
      playerTeams.remove(player);
    }

    team.addPlayer(player);
    playerTeams.put(player, team);
    player.teleport(team.getSpawnLocation());
    team.respawnPlayer(player);
  }

  public void close() {
    Bukkit.unloadWorld(world, false);
  }
}
