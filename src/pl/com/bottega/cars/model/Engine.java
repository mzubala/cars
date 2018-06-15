package pl.com.bottega.cars.model;

public interface Engine {

  void start();

  void stop();

  boolean isRunning();

  double calculateFuelConsumption(double distance);

}
