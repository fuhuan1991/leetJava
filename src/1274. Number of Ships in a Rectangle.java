/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

//class Solution1274 {
//
//  Sea sea;
//
//  public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
//    this.sea = sea;
//    return this.search(topRight, bottomLeft);
//  }
//
//  private int search(int[] topRight, int[] bottomLeft) {
//    int x1 = bottomLeft[0];
//    int x2 = topRight[0];
//    int y1 = bottomLeft[1];
//    int y2 = topRight[1];
//
//    if (x2 == x1 && y1 == y2) {
////      System.out.println(x1 + "," + y1 + " -> " + x2 + "," + y2);
////      System.out.println(this.sea.hasShips(topRight, bottomLeft));
//      return this.sea.hasShips(topRight, bottomLeft)? 1 : 0;
//    } else if (y1 == y2) {
//      int p1, p2;
//      p1 = x1 + (x2 - x1)/2;
//      p2 = p1 + 1;
//      int[] coor_1 = new int[]{x1, y1};
//      int[] coor_2 = new int[]{p1, y1};
//      int[] coor_3 = new int[]{p2, y1};
//      int[] coor_4 = new int[]{x2, y1};
//      int v1 = this.sea.hasShips(coor_2, coor_1)? this.search(coor_2, coor_1) : 0;
//      int v2 = this.sea.hasShips(coor_4, coor_3)? this.search(coor_4, coor_3) : 0;
////      System.out.println(x1 + "," + y1 + " -> " + x2 + "," + y2);
////      System.out.println(v1+v2);
//      return v1 + v2;
//    } else if (x1 == x2) {
//      int p1, p2;
//      p1 = y1 + (y2 - y1)/2;
//      p2 = p1 + 1;
//      int[] coor_1 = new int[]{x1, y1};
//      int[] coor_2 = new int[]{x1, p1};
//      int[] coor_3 = new int[]{x1, p2};
//      int[] coor_4 = new int[]{x1, y2};
//      int v1 = this.sea.hasShips(coor_2, coor_1)? this.search(coor_2, coor_1) : 0;
//      int v2 = this.sea.hasShips(coor_4, coor_3)? this.search(coor_4, coor_3) : 0;
////      System.out.println(x1 + "," + y1 + " -> " + x2 + "," + y2);
////      System.out.println(v1+v2);
//      return v1 + v2;
//    } else {
//      int px1, px2;
//      px1 = x1 + (x2 - x1)/2;
//      px2 = px1 + 1;
//
//      int py1, py2;
//      py1 = y1 + (y2 - y1)/2;
//      py2 = py1 + 1;
//
//      int[] coor_1 = new int[]{x1, py2};
//      int[] coor_2 = new int[]{px1, y2};
//
//      int[] coor_3 = new int[]{px2, py2};
//      int[] coor_4 = new int[]{x2, y2};
//
//      int[] coor_5 = new int[]{x1, y1};
//      int[] coor_6 = new int[]{px1, py1};
//
//      int[] coor_7 = new int[]{px2, y1};
//      int[] coor_8 = new int[]{x2, py1};
//
//      int v1 = this.sea.hasShips(coor_2, coor_1)? this.search(coor_2, coor_1) : 0;
//      int v2 = this.sea.hasShips(coor_4, coor_3)? this.search(coor_4, coor_3) : 0;
//      int v3 = this.sea.hasShips(coor_6, coor_5)? this.search(coor_6, coor_5) : 0;
//      int v4 = this.sea.hasShips(coor_8, coor_7)? this.search(coor_8, coor_7) : 0;
////      System.out.println(x1 + "," + y1 + " -> " + x2 + "," + y2);
////      System.out.println(v1+v2+v3+v4);
//      return v1 + v2 + v3  + v4;
//    }
//  }
//}