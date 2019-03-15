package com.rafibaum.athena.events;

import com.rafibaum.athena.Athena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinHandler implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    Athena.addSpectator(event.getPlayer());
  }

}
