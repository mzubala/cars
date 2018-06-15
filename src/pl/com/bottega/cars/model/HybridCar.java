package pl.com.bottega.cars.model;

public class HybridCar extends Car {

  public HybridCar(String name, double fuelAmount, HybridEngine engine) {
    super(name, fuelAmount, engine);
  }

  public HybridCar(String name, double fuelAmount, int x, int y, HybridEngine engine, BodyType bodyType) {
    super(name, fuelAmount, x, y, engine, bodyType);
  }
  
}
