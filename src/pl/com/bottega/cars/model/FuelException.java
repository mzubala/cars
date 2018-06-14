package pl.com.bottega.cars.model;

public class FuelException extends RuntimeException {

  public FuelException(double missingFuel) {
    super(String.format("You need more fuel: %f", missingFuel));
  }
}
