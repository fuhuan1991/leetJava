package AmazonOA;

import java.util.*;


public class PowerGrid {

  static class Connection{
    char from, to;
    int cost;
    public Connection(char from, char to, int cost){
      this.from = from;
      this.to = to;
      this.cost = cost;
    }

    @Override
    public String toString() {
      return "{" +
               from +
              "-->" + to +
              " " + cost +
              '}';
    }
  }

  public static void main(String[] args) {

    LinkedList<Connection> connections = new LinkedList<>();
    connections.add(new Connection('A', 'B', 1));
    connections.add(new Connection('B', 'C', 4));
    connections.add(new Connection('B', 'D', 6));
    connections.add(new Connection('D', 'E', 5));
    connections.add(new Connection('C', 'E', 1));
//    System.out.println(connections);
    // PQ--------------
    PriorityQueue<Connection> pq = new PriorityQueue<Connection>(new Comparator<>() {
      public int compare(Connection o1, Connection o2){
        return o1.cost - o2.cost;
      };
    });

    pq.addAll(connections);
//    while (pq.size() > 0) {
//      System.out.println(pq.poll());
//    }

    // leaderMap & groups--------------
    HashMap<Character, Character> leaderMap = new HashMap<>();
    HashMap<Character, ArrayList<Character>> groups = new HashMap<>();
    // traverse all the connections(edges)
    for (Connection c : connections) {
      char from = c.from;
      char to = c.to;
      if (!leaderMap.containsKey(from)) {
        leaderMap.put(from, from);
      }
      if (!leaderMap.containsKey(to)) {
        leaderMap.put(to, to);
      }
      if (!groups.containsKey(from)) {
        ArrayList<Character> list = new ArrayList<>();
        list.add(from);
        groups.put(from, list);
      }
      if (!groups.containsKey(to)) {
        ArrayList<Character> list = new ArrayList<>();
        list.add(to);
        groups.put(to, list);
      }
    }
//    System.out.println(leaderMap);
//    System.out.println(groups);

    // search--------------
    ArrayList<Connection> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      Connection c = pq.poll();
      char v1 = c.from;
      char v2 = c.to;

      char leader1 = leaderMap.get(v1);
      char leader2 = leaderMap.get(v2);

      if (leader1 == leader2) continue;
      result.add(c);
      ArrayList<Character> g1 = groups.get(leader1);
      ArrayList<Character> g2 = groups.get(leader2);

      for (char node : g2) {
        leaderMap.put(node, leader1);
        g1.addAll(g2);
      }
    }

    System.out.println(result);
  }
}
