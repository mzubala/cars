package pl.com.bottega.cars.model;

public abstract class DieselEngine extends CombustionEngine {

  @Override
  protected void init() {
    System.out.println("Świece żarowe!!!!");
  }

}
