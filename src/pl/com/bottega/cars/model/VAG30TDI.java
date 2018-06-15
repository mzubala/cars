package pl.com.bottega.cars.model;

public class VAG30TDI extends DieselEngine {
  @Override
  public double calculateFuelConsumption(double distance) {
    return distance * 10.0;
  }
}
