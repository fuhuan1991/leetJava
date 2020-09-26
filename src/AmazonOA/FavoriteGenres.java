package AmazonOA;

import java.util.*;
import java.util.LinkedList

public class FavoriteGenres {
  public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {

    HashMap<String, String> songMap = new HashMap<>();
    HashMap<String, List<String>> result = new HashMap<>();

    for (String g : genreMap.keySet()) {
      List<String> gList = genreMap.get(g);
      for (String song : gList) {
        songMap.put(song, g);
      }
    }

    System.out.println(songMap);

    for (String user : userMap.keySet()) {

      List<String> userList = userMap.get(user);
      HashMap<String, Integer> freq = new HashMap<>();
      List<String> r = new LinkedList<>();
      int max = 0;

      for (String song : userList) {
        // get the genre of a song
        String g = songMap.get(song);
        freq.putIfAbsent(g, 0);
        if (freq.get(g) + 1 > max) max = freq.get(g) + 1;
        freq.put(g, freq.get(g) + 1);
      }
      // add most frequent genres to result
      for (String g : freq.keySet()) {
        if (freq.get(g) == max) r.add(g);
      }

      result.put(user, r);
    }

    return result;
  }

  public static void main(String[] args) {
//    Map<String, List<String>> userMap = new HashMap<>();
//    List<String> list1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
//    List<String> list2 = Arrays.asList("song5", "song6", "song7");
//    userMap.put("David", list1);
//    userMap.put("Emma", list2);

//    Map<String, List<String>> genreMap = new HashMap<>();
//    List<String> list3 = Arrays.asList("song1", "song3");
//    List<String> list4 = Arrays.asList("song7");
//    List<String> list5 = Arrays.asList("song2", "song4");
//    List<String> list6 = Arrays.asList("song5", "song6");
//    List<String> list7 = Arrays.asList("song8", "song9");
//    genreMap.put("Rock", list3);
//    genreMap.put("Dubstep", list4);
//    genreMap.put("Techno", list5);
//    genreMap.put("Pop", list6);
//    genreMap.put("Jazz", list7);

    Map<String, List<String>> userMap = new HashMap<>();
		List<String> list1 = Arrays.asList("song1", "song2");
		List<String> list2 = Arrays.asList("song3", "song4");
		userMap.put("David", list1);
		userMap.put("Emma", list2);

		Map<String, List<String>> genreMap = new HashMap<>();

    System.out.println(favoritegenre(userMap, genreMap));
  }

}
