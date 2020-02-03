import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class SnakeGame {

  private Deque<int[]> snake;
  private int len;
  private HashMap<String, int[]> dirs;
  private int height;
  private int width;
  private LinkedList<int[]> foods;

  /** Initialize your data structure here.
   @param width - screen width
   @param height - screen height
   @param food - A list of food positions
   E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
  public SnakeGame(int width, int height, int[][] food) {
    this.len = 1;
    this.snake = new ArrayDeque<int[]>();
    this.snake.add(new int[]{0, 0});
    this.dirs = new HashMap<>();
    this.dirs.put("U", new int[]{-1, 0});
    this.dirs.put("L", new int[]{0, -1});
    this.dirs.put("R", new int[]{0, 1});
    this.dirs.put("D", new int[]{1, 0});
    this.height = height;
    this.width = width;
    this.foods = new LinkedList<>();
    for (int [] pos : food) {
      this.foods.add(pos);
    }
  }

  /** Moves the snake.
   @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
   @return The game's score after the move. Return -1 if game over.
   Game over when snake crosses the screen boundary or bites its body. */
  public int move(String direction) {
    int[] head = this.snake.peek();
    int[] offset = this.dirs.get(direction);
    int[] next = new int[]{head[0] + offset[0], head[1] + offset[1]};

    // check if the snake hits the wall
    if (next[0] < 0 || next[0] > this.height-1 || next[1] < 0 || next[1] > this.width-1) {
      return -1;
    }

    int[] nextFood = this.foods.peek();

    if (nextFood == null || !(nextFood[0] == next[0] && nextFood[1] == next[1])) {
      // eat nothing
      this.snake.removeLast();
    } else {
      // eat food
      this.foods.remove();
      this.len++;
    }

    // check if the snake hits itself
    for (int[] pos : this.snake) {
      if (pos[0] == next[0] && pos[1] == next[1]) {
        return -1;
      }
    }

    // add a new square to the snake
    this.snake.addFirst(next);
    return this.len-1;
  }

  public void show () {
    for (int[] pos : this.snake) {
      System.out.print("[" + pos[0] + " " +pos[1] + "] ");
    }
    System.out.print("\n");
  }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */