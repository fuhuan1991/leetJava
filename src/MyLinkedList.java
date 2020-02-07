class MyLinkedList {

  private Node head;
  private int len;
  private Node tail;

  /** Initialize your data structure here. */
  public MyLinkedList() {
    this.head = null;
    this.tail = null;
    this.len = 0;
  }

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    if (index >= this.len) {
      return -1;
    } else {
      Node current = this.head;
      while (index > 0) {
        current = current.next;
        index--;
      }
      return current.val;
    }
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
    this.len++;
    Node newNode = new Node(val);
    newNode.next = this.head;
    this.head = newNode;
    if (this.len == 1) this.tail = this.head;
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    this.len++;
    Node newNode = new Node(val);
    if (len == 1) {
      this.tail = newNode;
      this.head = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
    if (index == 0) {
      this.addAtHead(val);
    } else if (index == this.len) {
      this.addAtTail(val);
    } else if (index > this.len) {
      return;
    } else {
      Node current = this.head;
      while (index > 1) {
        current = current.next;
        index--;
      }
      Node newNode = new Node(val);
      Node afterNode = current.next;
      current.next = newNode;
      newNode.next = afterNode;
      len++;
    }
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    if (index == 0) {
      this.len--;
      if (len == 0) {
        this.head = null;
        this.tail = null;
      } else {
        this.head = this.head.next;
      }
    } else if (index >= this.len) {
      return;
    } else {
      this.len--;
      // index <= this.len-1
      Node current = this.head;
      while (index > 1) {
        current = current.next;
        index--;
      }
      if (current.next == this.tail) {
        current.next = null;
        this.tail = current;
      } else {
        current.next = current.next.next;
      }
    }
  }

  private class Node {
    public int val;
    public Node next;

    public Node(int val) {
       this.val = val;
       this.next = null;
    }
  }

  public void show () {
    Node current = this.head;
    System.out.print(this.len + "  ");
    while (current != null) {
      System.out.print(current.val + " -> ");
      current = current.next;
    }
    System.out.print("\n");
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */