package com.rafibaum.athena.events;

import com.rafibaum.athena.AthenaPlugin;
import com.rafibaum.athena.Team;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.Optional;

public class RespawnHandler implements Listener {

  @EventHandler
  public void onRespawn(PlayerRespawnEvent event) {
    Optional<Team> team = AthenaPlugin.getCurrentMatch().getTeam(event.getPlayer());
    if (team.isPresent()) {
      event.setRespawnLocation(team.get().getSpawnLocation());
      team.get().respawnPlayer(event.getPlayer());
    } else {
      event.setRespawnLocation(AthenaPlugin.getJoinLocation());
    }
  }

}
