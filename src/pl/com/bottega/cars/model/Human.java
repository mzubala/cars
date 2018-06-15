package pl.com.bottega.cars.model;

public class Human {

  private String name;

  public Human(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object obj) {
    if(!(obj instanceof Human))
      return false;
    Human human = (Human) obj;
    return human.name.equals(this.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}
