import java.lang.reflect.Method;
import java.util.*;

class Test {

  public static void main(String[] args) {
//    Solution331 obj = new Solution331();
//    System.out.println(obj.isValidSerialization("1,2,#,4,#,5,#,#,3,6,#,#,#"));
    Object o1 = new Object();
    Object o2 = new Object();

    System.out.println(o1.hashCode());
    System.out.println(o2.hashCode());
    System.out.println(o2.equals(o1));

  }

}