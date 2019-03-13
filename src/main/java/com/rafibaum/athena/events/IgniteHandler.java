package com.rafibaum.athena.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;

public class IgniteHandler implements Listener {

  @EventHandler
  public void onBurn(BlockIgniteEvent event) {
    if (event.getCause() == BlockIgniteEvent.IgniteCause.LAVA ||
            event.getCause() == BlockIgniteEvent.IgniteCause.LIGHTNING) {
      event.setCancelled(true);
    }
  }

}
