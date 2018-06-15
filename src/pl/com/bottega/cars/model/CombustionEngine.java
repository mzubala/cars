package pl.com.bottega.cars.model;

public abstract class CombustionEngine implements Engine {

  private boolean running;

  protected abstract void init();

  @Override
  public void start() {
    running = true;
    init();
  }

  @Override
  public void stop() {
    running = false;
  }

  @Override
  public boolean isRunning() {
    return running;
  }
}
