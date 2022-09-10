import publisher.YoutubeChannel;
import subscriber.User;

public class Main {

  public static void main(String[] args) {
    YoutubeChannel channel = new YoutubeChannel();

    channel.subscribe(new User("Hero"));
    channel.subscribe(new User("Chad"));
    channel.subscribe(new User("Peter"));

    if (uploadVideo()) {
      channel.notifyPush();
    }
  }

  private static boolean uploadVideo() {
    return true;
  }

}
