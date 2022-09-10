package subscriber;

public class User implements SubscribedUser{
  private String name;

  public User() {
  }

  public User(String name) {
    this.name = name;
  }

  @Override
  public void notifyUsers(String message) {
    makeSound();
    System.out.println(name + " : " + message);
  }

  private void makeSound() {
    System.out.println("알람~! 🎶🎶🎶");
  }
}
