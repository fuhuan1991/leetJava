import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution399 {
  private HashMap<String, HashMap<String, Double>> M;

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

    this.M = new HashMap<>();
    int len = values.length;

    for (int i = 0; i < len; ++i) {
      String v1 = equations.get(i).get(0);
      String v2 = equations.get(i).get(1);

      if (M.containsKey(v1)) {
        M.get(v1).put(v2, values[i]);
      } else {
        HashMap<String, Double> temp = new HashMap<>();
        temp.put(v2, values[i]);
        M.put(v1, temp);
      }

      if (M.containsKey(v2)) {
        M.get(v2).put(v1, 1/values[i]);
      } else {
        HashMap<String, Double> temp = new HashMap<>();
        temp.put(v1, 1/values[i]);
        M.put(v2, temp);
      }
    }

//    System.out.println(M);
    double[] result = new double[queries.size()];
    for (int i = 0; i < queries.size(); ++i) {
      System.out.println(queries.get(i).get(0));
      System.out.println(queries.get(i).get(1));
      Double r = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
      if (r == null) {
        result[i] = -1.0;
      } else {
        result[i] = r;
      }
    }
    return result;
  }

  private Double dfs(String v, String target, HashSet<String> visited) {

    if (!this.M.containsKey(v) || !this.M.containsKey(target)) return null;
    if (v.equals(target)) return 1.0;
    if (this.M.get(v).containsKey(target)) {
      // last step
      return this.M.get(v).get(target);
    } else {
      visited.add(v);
      // traverse all the neighbors
      for (String n : this.M.get(v).keySet()) {
        if (visited.contains(n)) continue;
        Double r = dfs(n, target, visited);
        if (r != null) return r * this.M.get(v).get(n);
      }
      visited.remove(v);
      return null;
    }
  }
}