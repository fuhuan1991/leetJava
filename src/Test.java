class Test {
  public static void main(String[] args){
    SnakeGame obj = new SnakeGame(2, 2, new int[][]{{0,1}});


    obj.show();
    obj.move("R");
    obj.show();
    obj.move("D");
    obj.show();
  }
}