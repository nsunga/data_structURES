public class MyArrayList {
  private int size = 0;
  private int[] items = new int[10];

  public MyArrayList() {}

  public void ensure_capacity() {
    if (this.items.length == this.size) {
      int[] new_items = new int[this.items.length * 2];
      for (int i = 0; i < this.size; i++) { new_items[i] = this.items[i]; }
      this.items = new_items;
    } else { return; }
  }

  public void add(int data) {
    this.ensure_capacity();
    this.items[this.size++] = data;
  }

  public void remove(int pos) {
    for (int i = pos; i < this.size-1; i++) { this.items[i] = this.items[i + 1]; }
    this.size--;
  }

  public void display() {
    for (int i = 0; i < this.size; i++) {
      System.out.print(this.items[i] + " ");
      if ((i + 1) == this.size) { System.out.println(); }
    }
  }

  public static void main(String[] args) {
    MyArrayList list = new MyArrayList();
    list.add(12);
    list.add(7);
    list.add(4);
    list.add(23);
    list.add(76);
    list.add(6);
    list.add(22);
    list.add(85);
    list.add(30);
    list.add(25);
    list.add(18);
    list.add(20);
    list.display();
    list.remove(6);
    list.display();
    list.remove(0);
    list.display();
    list.add(18);
    list.display();
  }
}
