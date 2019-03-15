package com.rafibaum.athena.events;

import com.rafibaum.athena.Athena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnHandler implements Listener {

  @EventHandler
  public void onRespawn(PlayerRespawnEvent event) {
    event.setRespawnLocation(Athena.respawnPlayer(event.getPlayer()));
  }

}
