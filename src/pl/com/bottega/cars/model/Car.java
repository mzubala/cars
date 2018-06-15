package pl.com.bottega.cars.model;

public class Car<LoadType> {

  private static final double MAX_FUEL_TANK_CAPACITY = 80;
  private final BodyType bodyType;

  private int x, y;

  private String name;

  private double fuelAmount = MAX_FUEL_TANK_CAPACITY;

  private Engine engine;

  private LoadType load;

  public Car(String name, double fuelAmount, Engine engine) {
    this(name, fuelAmount, 0, 0, engine, BodyType.SEDAN);
  }

  public Car(String name, double fuelAmount, int x, int y, Engine engine, BodyType bodyType) {
    if (x < 0 || y < 0 || fuelAmount > MAX_FUEL_TANK_CAPACITY) {
      throw new IllegalArgumentException();
    }
    this.x = x;
    this.y = y;
    this.name = name;
    this.fuelAmount = Math.min(fuelAmount, MAX_FUEL_TANK_CAPACITY);
    this.engine = engine;
    this.bodyType = bodyType;
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
    if (!engine.isRunning()) {
      throw new IllegalStateException();
    }
    double distance = (double) Math.abs(x) + Math.abs(y);
    double fuelNeeded = engine.calculateFuelConsumption(distance);
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
    if (!engine.isRunning()) {
      throw new IllegalStateException();
    }
    double fuelNeeded = engine.calculateFuelConsumption(distance);
    if (fuelNeeded > fuelAmount) {
      throw new FuelException(fuelNeeded - fuelAmount);
    }
    this.x = x;
    this.y = y;
    fuelAmount -= fuelNeeded;
  }

  public void run() {
    engine.start();
  }

  public void stop() {
    engine.stop();
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

  public int getDoorsCount() {
    return bodyType.getDoorsCount();
  }

  public void load(LoadType load) {
    this.load = load;
  }

  public LoadType unload() {
    LoadType tmp = load;
    load = null;
    return tmp;
  }
}
