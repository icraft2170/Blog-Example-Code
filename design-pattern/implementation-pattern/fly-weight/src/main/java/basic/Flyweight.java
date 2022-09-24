package basic;

/**
 * Flyweight 객체는 캐싱되어야 하고 공유되어야 하기 때문에 불변해야 한다. <- Kotlin의 Data Class
 * 조건 1 : 불변 상태
 * 조건 2 : 상속 X
 */
public record Flyweight(String name) {}
