package basic;

public class Main {

  public static void main(String[] args) {

    PrototypeProduct productA = new PrototypeProduct("상품A", 1_000_000L);

    PrototypeProduct cloneProductA = productA.clone();

    System.out.println(productA);
    System.out.println(cloneProductA);

    System.out.println("productA == cloneProductA -> " + (productA == cloneProductA) );
    System.out.println("productA equals cloneProductA -> " + (productA.equals(cloneProductA)) );
  }

}
