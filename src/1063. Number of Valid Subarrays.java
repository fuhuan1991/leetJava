import java.util.Stack;

class Solution1063 {
  public int validSubarrays(int[] nums) {
    if (nums.length == 0) return 0;

    Stack<Record> s = new Stack<>();
    int result = nums.length;

    for (int i = nums.length-1; i >= 0; --i) {

      Record record = new Record(nums[i], 1);

      while (!s.isEmpty() && s.peek().getValue() >= nums[i]) {
        // consume
        Record oldRecord = s.pop();
        result += oldRecord.getCounter();
        record.setCounter(record.getCounter() + oldRecord.getCounter());
      }

      s.push(record);
    }
    return result;
  }

  private class Record{
    private int value;
    private int counter;

    public Record(int value, int counter) {
      this.value = value;
      this.counter = counter;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public int getCounter() {
      return counter;
    }

    public void setCounter(int counter) {
      this.counter = counter;
    }
  }
}