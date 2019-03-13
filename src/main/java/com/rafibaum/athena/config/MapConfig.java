package com.rafibaum.athena.config;

import com.rafibaum.athena.Position;

import java.util.Arrays;
import java.util.List;

public class MapConfig {

  private String dirName;
  private Position spawnLocation;
  private List<TeamConfig> teams;

  public MapConfig(String dirName, Position spawnLocation, TeamConfig[] teams) {
    this.dirName = dirName;
    this.spawnLocation = spawnLocation;
    this.teams = Arrays.asList(teams);
  }

  public MapConfig() {

  }

  public String getDirName() {
    return dirName;
  }

  public void setDirName(String dirName) {
    this.dirName = dirName;
  }

  public Position getSpawnLocation() {
    return spawnLocation;
  }

  public void setSpawnLocation(Position spawnLocation) {
    this.spawnLocation = spawnLocation;
  }

  public List<TeamConfig> getTeams() {
    return teams;
  }

  public void addTeam(TeamConfig team) {
    teams.add(team);
  }

  public void setTeams(List<TeamConfig> teams) {
    this.teams = teams;
  }
}
