package com.rafibaum.athena.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreatureSpawnHandler implements Listener {

  @EventHandler
  public void onCreatureSpawn(CreatureSpawnEvent event) {
    CreatureSpawnEvent.SpawnReason reason = event.getSpawnReason();
    if (reason != CreatureSpawnEvent.SpawnReason.EGG) {
      event.setCancelled(true);
    }
  }

}
