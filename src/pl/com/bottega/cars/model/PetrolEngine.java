package pl.com.bottega.cars.model;

public abstract class PetrolEngine extends CombustionEngine {

  @Override
  protected void init() {
    System.out.println("Świece zapłonowe!!!!");
  }
}
