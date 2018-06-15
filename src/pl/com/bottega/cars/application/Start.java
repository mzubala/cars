package pl.com.bottega.cars.application;

import pl.com.bottega.cars.model.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Start {

  public static void main(String[] args) {
    Car<String> c1 = new Car<>("BMW", 60, new BMWN55());
    Car c2 = new Car("Fiat", 60, new VAG30TDI());

    c1.load("whiskey");
    c1.load("lm");
    c1.load("bimber");

    List<String> kontrabanda = c1.unload();

    Human human = new Human("Stefan Motyka");
    Human klon = new Human("Stefan Motyka");
    c1.getIn(human);
    c1.getIn(klon);
    c1.getIn(human);

    Parking parking = new Parking();
    parking.park(c1);
    parking.park(c2);
    parking.park(c1);
    parking.park(c1);
    parking.park(c1);
    parking.display();
    parking.leave(c1);
    parking.display();
    parking.leave(c2);
    parking.display();

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