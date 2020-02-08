import java.util.HashSet;
import java.util.Iterator;

class PhoneDirectory {

  private HashSet<Integer> freeNumbers;
  private HashSet<Integer> assignedNumbers;

  /** Initialize your data structure here
   @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
  public PhoneDirectory(int maxNumbers) {
    this.freeNumbers = new HashSet<>();
    this.assignedNumbers = new HashSet<>();

    for (int i = 0; i <= maxNumbers-1; ++i) {
      this.freeNumbers.add(i);
    }
  }

  /** Provide a number which is not assigned to anyone.
   @return - Return an available number. Return -1 if none is available. */
  public int get() {
    if (this.freeNumbers.isEmpty()) {
      return -1;
    } else {
      Iterator<Integer> iter = this.freeNumbers.iterator();
      Integer target = iter.next();
      this.freeNumbers.remove(target);
      this.assignedNumbers.add(target);
      return target;
    }
  }

  /** Check if a number is available or not. */
  public boolean check(int number) {
    return this.freeNumbers.contains(number);
  }

  /** Recycle or release a number. */
  public void release(int number) {
    this.assignedNumbers.remove(number);
    this.freeNumbers.add(number);
  }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */