package pl.com.bottega.cars.model;

public class HybridEngine implements Engine {

  private CombustionEngine combustionEngine;
  private ElectricEngine electricEngine;

  public HybridEngine(CombustionEngine combustionEngine, ElectricEngine electricEngine) {
    this.combustionEngine = combustionEngine;
    this.electricEngine = electricEngine;
  }

  @Override
  public void start() {
    combustionEngine.start();
    electricEngine.start();
  }

  @Override
  public void stop() {
    combustionEngine.stop();
    electricEngine.stop();
  }

  @Override
  public boolean isRunning() {
    return combustionEngine.isRunning() && electricEngine.isRunning();
  }

  @Override
  public double calculateFuelConsumption(double distance) {
    return combustionEngine.calculateFuelConsumption(distance) * 0.5;
  }
}
