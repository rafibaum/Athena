package com.rafibaum.athena.events;

import com.rafibaum.athena.AthenaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveHandler implements Listener {

  @EventHandler
  public void onLeave(PlayerQuitEvent event) {
    AthenaPlugin.removeSpectator(event.getPlayer());
  }

}
