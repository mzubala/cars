package pl.com.bottega.cars.model;

public class ElectricEngine implements Engine {

  private boolean running;

  @Override
  public void start() {
    running = true;
  }

  @Override
  public void stop() {
    running = false;
  }

  @Override
  public boolean isRunning() {
    return running;
  }

  @Override
  public double calculateFuelConsumption(double distance) {
    return 0;
  }
}
