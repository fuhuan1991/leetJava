import java.util.function.IntConsumer;

class FizzBuzz {
  private int n;
  private int current;

  public FizzBuzz(int n) {
    this.n = n;
    this.current = 1;
  }

  // printFizz.run() outputs "fizz".
  public synchronized void fizz(Runnable printFizz) throws InterruptedException {
    while (this.current <= this.n) {
      if (current%3 == 0 && current%5 != 0) {
        printFizz.run();
        this.current++;
        notifyAll();
      } else {
        wait();
      }
    }
  }

  // printBuzz.run() outputs "buzz".
  public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
    while (this.current <= this.n) {
      if (current%5 == 0 && current%3 != 0) {
        printBuzz.run();
        this.current++;
        notifyAll();
      } else {
        wait();
      }
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    while (this.current <= this.n) {
      if (current%15 == 0) {
        printFizzBuzz.run();
        this.current++;
        notifyAll();
      } else {
        wait();
      }
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public synchronized void number(IntConsumer printNumber) throws InterruptedException {
    while (this.current <= this.n) {
      if (current%3 != 0 && current%5 != 0 ) {
        printNumber.accept(current);
        this.current++;
        notifyAll();
      } else {
        wait();
      }
    }
  }
}