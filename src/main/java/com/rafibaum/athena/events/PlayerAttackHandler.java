package com.rafibaum.athena.events;

import com.rafibaum.athena.AthenaPlugin;
import com.rafibaum.athena.Team;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerAttackHandler implements Listener {

  @EventHandler
  public void onHit(EntityDamageByEntityEvent event) {
    if (event.getDamager().getType() != EntityType.PLAYER || event.getEntity().getType() != EntityType.PLAYER) return;

    Player damager = (Player) event.getDamager();
    Player receiver = (Player) event.getEntity();

    if (AthenaPlugin.getCurrentMatch().getTeam(damager).isPresent() &&
        AthenaPlugin.getCurrentMatch().getTeam(receiver).isPresent()) {
      Team dTeam = AthenaPlugin.getCurrentMatch().getTeam(damager).get();
      Team rTeam = AthenaPlugin.getCurrentMatch().getTeam(receiver).get();

      if (dTeam == rTeam) {
        event.setCancelled(true);
      }
    } else {
      event.setCancelled(true);
    }
  }

}
