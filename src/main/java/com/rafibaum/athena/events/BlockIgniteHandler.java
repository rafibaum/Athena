package com.rafibaum.athena.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;

public class BlockIgniteHandler implements Listener {

  @EventHandler
  public void onBlockIgnore(BlockIgniteEvent event) {
    BlockIgniteEvent.IgniteCause cause = event.getCause();
    if (!(cause == BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL || cause == BlockIgniteEvent.IgniteCause.SPREAD)) {
      event.setCancelled(true);
    }
  }

}
