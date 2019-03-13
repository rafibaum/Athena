package com.rafibaum.athena;

public class MapConfig {

  private String dirName;
  private Position spawnLocation;


  public MapConfig(String dirName, Position spawnLocation) {
    this.dirName = dirName;
    this.spawnLocation = spawnLocation;
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
}
