public class LinkedList {
  Node head;

  public LinkedList() {}

  public LinkedList(int data) { this.head = new Node(data); }

  public void push_back(int data) {
    if (this.head == null) {
      this.head = new Node(data);
      return;
    }
    Node current = this.head;
    while (current.next != null) { current = current.next; }
    current.next = new Node(data);
  }

  public void prepend(int data) {
    if (this.head == null) {
      this.head = new Node(data);
      return;
    }
    Node new_head = new Node(data);
    new_head.next = this.head;
    this.head = new_head;
  }

  public void delete(int data) {
    if (head == null) { return; }
    if (this.head.data == data) { this.head = this.head.next; }
    Node current = this.head;

    while (current.next != null) {
      if (current.next.data == data) {
        current.next = current.next.next;
        return;
      }
      current = current.next;
    }
  }

  public void display() {
    Node current = this.head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }

  public LinkedList reverse() {
    Node current = this.head;
    LinkedList reversed = new LinkedList();
    while (current != null) {
      reversed.prepend(current.data);
      current = current.next;
    }

    return reversed;
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList(12);
    list.push_back(15);
    list.push_back(90);
    list.push_back(1);
    list.push_back(843);
    list.push_back(123);
    list.push_back(8);

    list.display();
    System.out.println("DELETING VALUE 123");
    list.delete(123);
    list.display();
    System.out.println("DELETING VALUE 12");
    list.delete(12);
    list.display();

    LinkedList reversed = list.reverse();
    reversed.display();
  }
}
