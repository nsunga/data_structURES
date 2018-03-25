public class Queue {
  // FIFO
  private Node head;
  private Node tail;

  public boolean isEmpty() { return head == null; }

  public int peek() { return this.head.data; }

  public void add(int data) {
    Node node = new Node(data);
    if (tail != null) {
      tail.next = node;
    }
    tail = node;
    if (head == null) {
      head = node;
    }
  }

  public int remove() {
    int value = head.data;
    this.head = this.head.next;
    if (this.head == null) { this.tail = null; }
    return value;
  }
}
