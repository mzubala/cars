package pl.com.bottega.cars.application;

import pl.com.bottega.cars.model.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Start {

  public static void main(String[] args) {
    Car<ElectricEngine> c1 = new Car<>("BMW", 60, new BMWN55());
    Car c2 = new Car("Fiat", 60, new VAG30TDI());

    c1.load(new ElectricEngine());
    ElectricEngine x = c1.unload();

    Car[] cars = new Car[]{c1, c2};
    Arrays.sort(cars, new Comparator<Car>() {
      @Override
      public int compare(Car o1, Car o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });

    Car car = new HybridCar("BMW", 60, new HybridEngine(new VAG30TDI(), new ElectricEngine()));
    System.out.println(car.getDoorsCount());
    car.run();
    while (true) {
      String userMove = getUserMove();
      switch (userMove) {
        case "w":
          car.top();
          break;
        case "a":
          car.left();
          break;
        case "s":
          car.down();
          break;
        case "d":
          car.right();
          break;
        default:
          System.out.println("only w a s d moves are supported");
      }
      System.out.println(car);
    }
  }

  private static String getUserMove() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

}