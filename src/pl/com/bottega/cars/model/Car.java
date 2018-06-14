package pl.com.bottega.cars.model;

import java.io.IOException;

public class Car {

  private static final double MAX_FUEL_TANK_CAPACITY = 80;

  private int x, y;

  private String name;

  private double fuelAmount = MAX_FUEL_TANK_CAPACITY,
      fuelConsumption = 10;

  public Car(String name, double fuelAmount, double fuelConsumption) {
    this(name, fuelAmount, fuelConsumption, 0, 0);
  }

  public Car(String name, double fuelAmount, double fuelConsumption, int x, int y) {
    if(x < 0 || y < 0 || fuelAmount > MAX_FUEL_TANK_CAPACITY) {
      throw new IllegalArgumentException();
    }
    this.x = x;
    this.y = y;
    this.name = name;
    this.fuelAmount = Math.min(fuelAmount, MAX_FUEL_TANK_CAPACITY);
    this.fuelConsumption = fuelConsumption;
  }

  public void left() {
    moveBy(-1, 0);
  }

  public void right() {
    moveBy(1, 0);
  }

  public void top() {
    moveBy(0, 1);
  }

  public void down() {
    moveBy(0, -1);
  }

  public void left(int distance) {
    moveBy(-distance, 0);
  }

  public void right(int distance) {
    moveBy(distance, 0);
  }

  public void top(int distance) {
    moveBy(0, distance);
  }

  public void down(int distance) {
    moveBy(0, -distance);
  }

  private void moveBy(int x, int y) {
    if (this.x + x < 0 || this.y + y < 0) {
      throw new IllegalArgumentException();
    }
    double distance = (double) Math.abs(x) + Math.abs(y);
    double fuelNeeded = distance * fuelConsumption;
    if (fuelNeeded > fuelAmount) {
      throw new FuelException(fuelNeeded - fuelAmount);
    }
    this.x += x;
    this.y += y;
    fuelAmount -= fuelNeeded;
  }

  public void moveTo(int x, int y) {
    double distance = Math.abs(this.x - x) + Math.abs(this.y - y);
    consumeFuelAndMove(x, y, distance);
  }

  public void shortMove(int x, int y) {
    double distance = Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    consumeFuelAndMove(x, y, distance);
  }

  private void consumeFuelAndMove(int x, int y, double distance) {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException();
    }
    double fuelNeeded = distance * fuelConsumption;
    if (fuelNeeded > fuelAmount) {
      throw new FuelException(fuelNeeded - fuelAmount);
    }
    this.x = x;
    this.y = y;
    fuelAmount -= fuelNeeded;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public double getFuelAmount() {
    return fuelAmount;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return String.format("x=%d y=%d fuel=%f", x, y, fuelAmount);
  }
}
