package pl.com.bottega.cars.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CarTest {

  private Car car = new Car("BMW", 50, 10);

  @Test
  public void changesPositionToSpecificPoint() {
    //when
    car.moveTo(2, 2);

    //then
    assertEquals(2, car.getX());
    assertEquals(2, car.getY());
  }

  @Test(expected = FuelException.class)
  public void throwsExceptionWhenThereIsNotEnoughFuelToMove() {
    Car car = new Car("BMW", 0, 10);

    car.moveTo(1, 1);
  }

  @Test
  public void consumesFuelWhenMoving() {
    car.moveTo(1, 1);

    assertEquals(30, car.getFuelAmount(), 0.001);
  }

  @Test
  public void makesShortMove() {
    car.shortMove(1, 1);

    assertEquals(50 - (Math.sqrt(2) * 10), car.getFuelAmount(), 0.001);
  }

}
