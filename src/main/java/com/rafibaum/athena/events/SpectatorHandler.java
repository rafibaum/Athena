package com.rafibaum.athena.events;

import com.rafibaum.athena.Athena;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;

public class SpectatorHandler implements Listener {

  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    if (Athena.isSpectator(event.getPlayer())) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onBlockPlace(BlockPlaceEvent event) {
    if (Athena.isSpectator(event.getPlayer())) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    if (Athena.isSpectator(event.getPlayer())) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onPlayerEntityInteract(PlayerInteractEntityEvent event) {
    if (Athena.isSpectator(event.getPlayer())) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onPlayerAtEntityInteract(PlayerInteractAtEntityEvent event) {
    if (Athena.isSpectator(event.getPlayer())) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onEntityDamage(EntityDamageByEntityEvent event) {
    if (event.getDamager().getType() == EntityType.PLAYER) {
      Player player = (Player) event.getDamager();
      if (Athena.isSpectator(player)) {
        event.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onEntityTarget(EntityTargetEvent event) {
    if (event.getTarget().getType() == EntityType.PLAYER) {
      Player player = (Player) event.getTarget();
      if (Athena.isSpectator(player)) {
        event.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onDropItem(PlayerDropItemEvent event) {
    if (Athena.isSpectator(event.getPlayer())) {
      event.getItemDrop().remove();
    }
  }

  @EventHandler
  public void onItemPickup(EntityPickupItemEvent event) {
    if (event.getEntity().getType() == EntityType.PLAYER) {
      Player player = (Player) event.getEntity();
      if (Athena.isSpectator(player)) {
        event.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    if (event.getWhoClicked().getType() == EntityType.PLAYER) {
      Player player = (Player) event.getWhoClicked();
      if (Athena.isSpectator(player) && event.getClickedInventory().getHolder() != player) {
        event.setCancelled(true);
      }
    }
  }

}
