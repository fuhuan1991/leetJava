class Test {
  public static void main(String[] args){
    MyLinkedList obj = new MyLinkedList();
    obj.addAtHead(10);
    obj.show();
    obj.addAtTail(3);
    obj.show();
    obj.addAtIndex(1,2);
    obj.show();
    obj.get(1);
    obj.deleteAtIndex(0);
    obj.show();
    obj.get(1);
  }
}