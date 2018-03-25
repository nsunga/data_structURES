public class Stack {
  // LIFO
  private Node top;

  public boolean isEmpty() { return top == null; }

  // if top null, throw exception
  public int peek() { return this.top.data; }

  public void push(int data) {
    Node new_top = new Node(data);
    new_top.next = this.top;
    this.top = new_top;
  }

  // if top null, throw exception
  public int pop() {
    int value = this.top.data;
    this.top = this.top.next;
    return value;
  }
}
