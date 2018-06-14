package pl.com.bottega.cars.application;

import pl.com.bottega.cars.model.Car;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Start {

  public static void main(String[] args) {
    Car c1 = new Car("BMW", 60, 10);
    Car c2 = new Car("Fiat", 60, 10);


    Car[] cars = new Car[]{c1, c2};
    Arrays.sort(cars, new Comparator<Car>() {
      @Override
      public int compare(Car o1, Car o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });

    Car car = new Car("BMW", 60, 10);
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