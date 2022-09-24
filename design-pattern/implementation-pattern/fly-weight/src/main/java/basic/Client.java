package basic;

public class Client {
  static FlyweightFactory factory = new FlyweightFactory();

  public static void main(String[] args) {
    Flyweight hero = factory.getCache("Hero");
    System.out.println(hero.name() + " -> hero1 hash : " + hero.hashCode());

    Flyweight hero2 = factory.getCache("Hero");
    System.out.println(hero2.name() + " -> hero2 hash : " + hero2.hashCode());

    System.out.println("hero equals hero2 -> " + (hero.equals(hero2)));
  }
}
