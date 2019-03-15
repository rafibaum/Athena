package com.rafibaum.athena.config;

import com.rafibaum.athena.Position;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RaceForVictory3 extends MapConfig {

  public RaceForVictory3() {
    super();
    setDirName("raceforvictory3");
    setSpawnPosition(new Position(44.5, 8, 0.5, -90.0f, 0.0f));

    Inventory spawnItems = Bukkit.createInventory(null, InventoryType.PLAYER);

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
    blueTeam.setColor(ChatColor.BLUE);
    blueTeam.setName("Blue");
    blueTeam.setSpawnItems(spawnItems);
    blueTeam.setSpawnPosition(new Position(0.5, 2, 91.5, 180, 0));
    addTeam(blueTeam);

    TeamConfig redTeam = new TeamConfig();
    redTeam.setColor(ChatColor.RED);
    redTeam.setName("Red");
    redTeam.setSpawnItems(spawnItems);
    redTeam.setSpawnPosition(new Position(0.5, 2, -90.5, 0, 0));
    addTeam(redTeam);
  }

}
