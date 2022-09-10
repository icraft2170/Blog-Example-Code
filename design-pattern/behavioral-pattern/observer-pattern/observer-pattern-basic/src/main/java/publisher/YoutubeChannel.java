package publisher;

import java.util.HashSet;
import java.util.Set;
import subscriber.SubscribedUser;

public class YoutubeChannel {
  private Set<SubscribedUser> subscribers = new HashSet<>();
  public void subscribe(SubscribedUser user) {
    subscribers.add(user);
  }

  public void unSubscribe(SubscribedUser user) {
    subscribers.remove(user);
  }

  public void notifyPush() {
    subscribers.forEach((subscribedUser) -> {
      subscribedUser.notifyUsers("Hero Channel 에 새로운 영상이 올라왔습니다.");
    });
  }
}
