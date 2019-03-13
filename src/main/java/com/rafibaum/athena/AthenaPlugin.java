package com.rafibaum.athena;

import com.rafibaum.athena.config.MapConfig;
import com.rafibaum.athena.config.TeamConfig;
import com.rafibaum.athena.events.*;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class AthenaPlugin extends JavaPlugin {

  private static Match currentMatch;
  private static List<Player> spectators;

  @Override
  public void onDisable() {
    currentMatch.close();
  }

  @Override
  public void onEnable() {
    MapConfig rfv3 = new MapConfig();
    rfv3.setDirName("raceforvictory3");
    rfv3.setSpawnLocation(new Position(44.5, 8, 0.5, -90.0f, 0.0f));

    PlayerInventory spawnItems = (PlayerInventory) Bukkit.createInventory(null, InventoryType.PLAYER);

    spawnItems.setItem(0, new ItemStack(Material.IRON_SWORD));

    ItemStack bow = new ItemStack(Material.BOW);
    bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
    spawnItems.setItem(1, bow);

    spawnItems.setItem(28, new ItemStack(Material.ARROW));

    ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE);
    pickaxe.addEnchantment(Enchantment.DURABILITY, 3);
    pickaxe.addEnchantment(Enchantment.DIG_SPEED, 1);
    spawnItems.setItem(2, pickaxe);

    spawnItems.setItem(3, new ItemStack(Material.IRON_AXE));
    spawnItems.setItem(4, new ItemStack(Material.LOG, 64, (short) 1));
    spawnItems.setItem(5, new ItemStack(Material.GLASS, 64));
    spawnItems.setItem(6, new ItemStack(Material.BUCKET));
    spawnItems.setItem(7, new ItemStack(Material.GOLDEN_APPLE));
    spawnItems.setItem(8, new ItemStack(Material.COOKED_FISH, 64));

    TeamConfig blueTeam = new TeamConfig();
    blueTeam.setColor(Color.BLUE);
    blueTeam.setName("Blue");
    blueTeam.setSpawnItems(spawnItems);
    blueTeam.setSpawnLocation(new Position(0.5, 2, 91.5, 180, 0));
    rfv3.addTeam(blueTeam);

    TeamConfig redTeam = new TeamConfig();
    redTeam.setColor(Color.RED);
    redTeam.setName("Red");
    redTeam.setSpawnItems(spawnItems);
    redTeam.setSpawnLocation(new Position(0.5, 2, -90.5, 0, 0));
    rfv3.addTeam(redTeam);

    currentMatch = new Match(rfv3);

    spectators = new ArrayList<Player>();

    registerEvents();
  }

  public void registerEvents() {
    PluginManager pm = getServer().getPluginManager();

    pm.registerEvents(new JoinHandler(), this);
    pm.registerEvents(new WeatherHandler(), this);
    pm.registerEvents(new LeaveHandler(), this);
    pm.registerEvents(new SpectatorHandler(), this);
    pm.registerEvents(new IgniteHandler(), this);
    pm.registerEvents(new CreatureSpawnHandler(), this);
    pm.registerEvents(new RespawnHandler(), this);
    pm.registerEvents(new PlayerAttackHandler(), this);
  }

  public static Location getJoinLocation() {
    return currentMatch.getSpawnLocation();
  }

  public static void addSpectator(Player spectator) {
    spectators.add(spectator);
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (!isSpectator(player)) {
        player.hidePlayer(spectator);
      }
    }
  }

  public static boolean isSpectator(Player spectator) {
    return spectators.contains(spectator);
  }

  public static void removeSpectator(Player spectator) {
    spectators.remove(spectator);

    for (Player player : Bukkit.getOnlinePlayers()) {
      if (!isSpectator(player)) {
        player.showPlayer(spectator);
      }
    }
  }

  public static Match getCurrentMatch() {
    return currentMatch;
  }
}
