import java.util.*;

class Twitter {

  private HashMap<Integer, HashSet<Integer>> followMap;
  private HashMap<Integer, LinkedList<int[]>> tweetsMap;
  private int timestamp;

  /** Initialize your data structure here. */
  public Twitter() {
    this.followMap = new HashMap<>();
    this.tweetsMap = new HashMap<>();
    this.timestamp = 0;
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    LinkedList<int[]> tweetList;

    if (this.tweetsMap.get(userId) != null) {
      tweetList = this.tweetsMap.get(userId);
    } else {
      tweetList = new LinkedList<int[]>();
      this.tweetsMap.put(userId, tweetList);
    }

    int[] tweet = new int[]{tweetId, this.timestamp++};
    tweetList.add(tweet);
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
    HashSet<Integer> followees = this.followMap.get(userId);

    Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);

    if (followees != null && !followees.isEmpty()) {
      for (Integer id : followees) {
        LinkedList<int[]> list = this.tweetsMap.get(id);
        if (list == null || list.isEmpty()) continue;
        for (int i = list.size() - 1; i >= 0 && i >= list.size() - 10; --i) {
          queue.add(list.get(i));
        }
      }
    }

    //self
    LinkedList<int[]> selfList = this.tweetsMap.get(userId);
    if (selfList != null && !selfList.isEmpty()) {
      for (int i = selfList.size() - 1; i >= 0 && i >= selfList.size() - 10; --i) {
        queue.add(selfList.get(i));
      }
    }

    int counter = 10;
    List<Integer> result = new LinkedList<>();
    while (counter > 0 && !queue.isEmpty()) {
      result.add(queue.remove()[0]);
      counter--;
    }
    return result;
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    if (followerId == followeeId) return;
    HashSet<Integer> set;
    if (this.followMap.get(followerId) != null) {
      set = this.followMap.get(followerId);
    } else {
      set = new HashSet<Integer>();
      this.followMap.put(followerId, set);
    }
    set.add(followeeId);
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    if (this.followMap.get(followerId) == null) {
      return;
    } else {
      HashSet<Integer> set = this.followMap.get(followerId);
      set.remove(followeeId);
    }
  }

  public void show() {
    for (int id : this.tweetsMap.keySet()) {
      System.out.print(id + " => ");
      for (int[] tweet : this.tweetsMap.get(id)) {
        System.out.print(" [" + tweet[0] + " | " + tweet[1] + "] ");
      }
      System.out.print("\n");
    }

    System.out.println("=====================");


    for (int id : this.followMap.keySet()) {
      System.out.print(id + " => ");
      for (Integer followee : this.followMap.get(id)) {
        System.out.print(followee + " ");
      }
      System.out.print("\n");
    }
  }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */