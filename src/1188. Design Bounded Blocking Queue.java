import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBlockingQueue {

  Deque<Integer> queue;
  ReentrantLock lock;
  Condition condition;
  int max;

  public BoundedBlockingQueue(int capacity) {
    this.queue = new LinkedList<>();
    this.lock = new ReentrantLock();
    this.condition = this.lock.newCondition();
    this.max = capacity;
  }

  public void enqueue(int element) throws InterruptedException {
    this.lock.lock();
    while (this.queue.size() == this.max) {
      this.condition.await();
    }
    this.queue.offer(element);
    this.condition.signalAll();
    this.lock.unlock();
  }

  public int dequeue() throws InterruptedException {
    this.lock.lock();
    while (this.queue.isEmpty()) {
      this.condition.await();
    }
    int ele = this.queue.poll();
    this.condition.signalAll();
    this.lock.unlock();
    return ele;
  }

  public int size() {
    return this.queue.size();
  }
}