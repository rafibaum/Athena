package com.rafibaum.athena.config;

import com.rafibaum.athena.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapConfig {

  private String dirName;
  private Position spawnPosition;
  private List<TeamConfig> teams;

  public MapConfig(String dirName, Position spawnPosition, TeamConfig[] teams) {
    this.dirName = dirName;
    this.spawnPosition = spawnPosition;
    this.teams = Arrays.asList(teams);
  }

  public MapConfig() {
    this.teams = new ArrayList<>();
  }

  public String getDirName() {
    return dirName;
  }

  public void setDirName(String dirName) {
    this.dirName = dirName;
  }

  public Position getSpawnPosition() {
    return spawnPosition;
  }

  public void setSpawnPosition(Position spawnLocation) {
    this.spawnPosition = spawnLocation;
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
