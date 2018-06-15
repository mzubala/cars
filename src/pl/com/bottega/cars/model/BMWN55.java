package pl.com.bottega.cars.model;

public class BMWN55 extends PetrolEngine {
  @Override
  public double calculateFuelConsumption(double distance) {
    return distance * 20;
  }
}
