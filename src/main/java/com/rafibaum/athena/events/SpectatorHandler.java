package com.rafibaum.athena.events;

import com.rafibaum.athena.AthenaPlugin;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SpectatorHandler implements Listener {

  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    if (AthenaPlugin.isSpectator(event.getPlayer())) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onBlockPlace(BlockPlaceEvent event) {
    if (AthenaPlugin.isSpectator(event.getPlayer())) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    if (AthenaPlugin.isSpectator(event.getPlayer())) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onPlayerEntityInteract(PlayerInteractEntityEvent event) {
    if (AthenaPlugin.isSpectator(event.getPlayer())) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onPlayerAtEntityInteract(PlayerInteractAtEntityEvent event) {
    if (AthenaPlugin.isSpectator(event.getPlayer())) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onEntityDamage(EntityDamageByEntityEvent event) {
    if (event.getDamager().getType() == EntityType.PLAYER) {
      Player player = (Player) event.getDamager();
      if (AthenaPlugin.isSpectator(player)) {
        event.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onEntityTarget(EntityTargetEvent event) {
    if (event.getTarget().getType() == EntityType.PLAYER) {
      Player player = (Player) event.getTarget();
      if (AthenaPlugin.isSpectator(player)) {
        event.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onCreateInventory(InventoryCreativeEvent event) {
    if (event.getWhoClicked().getType() == EntityType.PLAYER) {
      Player player = (Player) event.getWhoClicked();
      if (AthenaPlugin.isSpectator(player)) {
        event.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onDropItem(PlayerDropItemEvent event) {
    if (AthenaPlugin.isSpectator(event.getPlayer())) {
      event.setCancelled(true);
    }
  }

}
