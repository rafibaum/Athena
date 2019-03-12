package com.rafibaum.athena.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherHandler implements Listener {

  @EventHandler
  public void onWeatherChange(WeatherChangeEvent event) {
    event.setCancelled(event.toWeatherState());
  }

}
