class Test {
  public static void main(String[] args){
    Twitter T = new Twitter();
    T.follow(1,5);
//    T.postTweet(1, 1001);
//    T.postTweet(1, 1002);
//    T.postTweet(1, 1003);
//    T.postTweet(2, 1004);
//    T.postTweet(2, 1005);
//    T.postTweet(2, 1006);
//    T.postTweet(3, 1007);
//    T.postTweet(3, 1008);
//
//    T.follow(1,2);
//    T.follow(1,3);
//    T.follow(1,4);
//    T.follow(1,5);
//    T.follow(1,6);

    T.show();
    System.out.println(T.getNewsFeed(1));
  }
}