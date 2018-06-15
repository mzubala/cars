package pl.com.bottega.cars.model;

import java.util.Map;
import java.util.TreeMap;

public class Parking {

  private static final int LOTS_COUNT = 10;

  private Map<String, Car> parkingLots = new TreeMap<>();

  public Parking() {
    for(int i = 1; i<=LOTS_COUNT; i++) {
      parkingLots.put("A" + i, null);
    }
  }

  public void park(Car car) {
    if(parkingLots.containsValue(car)) {
      return;
    }
    for(String lotName : parkingLots.keySet()) {
      if(parkingLots.get(lotName) == null) {
        parkingLots.put(lotName, car);
        return;
      }
    }
    throw new IllegalStateException("no lots available");
  }

  public void leave(Car car) {
    for(String lotName : parkingLots.keySet()) {
      if(car.equals(parkingLots.get(lotName))) {
        parkingLots.put(lotName, null);
        return;
      }
    }
    throw new IllegalStateException("no such car parked");
  }

  public void display() {
    for(Map.Entry<String, Car> entry : parkingLots.entrySet()) {
      System.out.print(entry.getKey() + " -> ");
      if(entry.getValue() == null) {
        System.out.print("empty");
      }
      else {
        System.out.print(entry.getValue());
      }
      System.out.println();
    }
  }

}
