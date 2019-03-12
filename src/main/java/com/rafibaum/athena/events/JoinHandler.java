package com.rafibaum.athena.events;

import com.rafibaum.athena.AthenaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinHandler implements Listener {

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    event.getPlayer().teleport(AthenaPlugin.getJoinLocation());
  }

}
