package binarysearch;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test {

  public static final int NUMBERS = 100;
  public static final int MAX_VALUE = 100000000;
  static BinarySearch search = new BinarySearch();

  public static void main(String[] args) {
    long countTotal = 0L;
    for (int i = 0; i < MAX_VALUE; i++) {
      int target = (int) (Math.random() * NUMBERS + 1);
      int[] array = Arrays.stream(IntStream.range(1, NUMBERS).toArray()).toArray();
      int count = search.binarySearch(array, target);
      countTotal += count;
    }
    long avgCount = countTotal / MAX_VALUE;
    System.out.println(avgCount);
  }
  // 1_000 대해 100000000번 테스트 평균 5회
}
