package pl.com.bottega.cars.model;

public enum BodyType {
  COUPE(2, 2), SEDAN(4, 5), HATCH_BACK(5, 5), COMPACT(5, 5);

  private int doorsCount;

  private int passengerCount;

  BodyType(int doorsCount, int passengerCount) {
    this.doorsCount = doorsCount;
    this.passengerCount = passengerCount;
  }

  public int getPassengerCount() {
    return passengerCount;
  }

  public int getDoorsCount() {
    return doorsCount;
  }

  public boolean canFitMoreThan(int size) {
    return size < passengerCount;
  }
}
