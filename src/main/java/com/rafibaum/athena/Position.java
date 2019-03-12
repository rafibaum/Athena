package com.rafibaum.athena;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class Position {

  private final double x;
  private final double y;
  private final double z;
  private final float yaw;
  private final float pitch;

  public Position(Vector vector, float yaw, float pitch) {
    this(vector.getX(), vector.getY(), vector.getZ(), yaw, pitch);
  }

  public Position(double x, double y, double z, float yaw, float pitch) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.yaw = yaw;
    this.pitch = pitch;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getZ() {
    return z;
  }

  public float getYaw() {
    return yaw;
  }

  public float getPitch() {
    return pitch;
  }

  public Location getLocation(World world) {
    return new Location(world, x, y, z, yaw, pitch);
  }
}
