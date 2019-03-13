package com.rafibaum.athena.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreatureSpawnHandler implements Listener {

  @EventHandler
  public void onSpawn(CreatureSpawnEvent event) {
    if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL ||
        event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.BUILD_IRONGOLEM ||
        event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.BUILD_SNOWMAN ||
        event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.BUILD_WITHER) {
      event.setCancelled(true);
    }
  }

}
