import java.util.Arrays;

public class MinIntHeap {
  private int capacity = 10;
  private int size = 0;
  int[] items = new int[capacity];

  private int get_left_child_index(int parent_index) { return ((parent_index * 2) + 1); }
  private int get_right_child_index(int parent_index) { return ((parent_index * 2) + 2); }
  private int get_parent_index(int child_index) { return ((child_index - 1)/2); }

  private boolean has_left_child(int parent_index) { return get_left_child_index(parent_index) < this.size; }
  private boolean has_right_child(int parent_index) { return get_right_child_index(parent_index) < this.size; }
  private boolean has_parent(int child_index) { return get_parent_index(child_index) >= 0; }

  private int left_child(int index) { return items[get_left_child_index(index)]; }
  private int right_child(int index) { return items[get_right_child_index(index)]; }
  private int parent(int index) { return items[get_parent_index(index)]; }

  private void swap(int index_one, int index_two) {
    int temp = index_one;
    items[index_one] = items[index_two];
    items[index_two] = temp;
  }

  private void ensure_extra_capacity() {
    if (this.size == capacity) {
      this.items = Arrays.copyOf(this.items, capacity * 2);
      this.capacity *= 2;
    }
  }

  public int peek() {
    if (this.size == 0) { throw new IllegalStateException(); }
    else { return this.items[0]; }
  }

  public int poll() {
    if (this.size == 0) { throw new IllegalStateException(); }

    int value = this.items[0];
    this.items[0] = this.items[this.size - 1];
    this.size--;
    heapify_down();
    return value;
  }

  public void add(int item) {
    ensure_extra_capacity();
    this.items[this.size] = item;
    size++;
    heapify_up();
  }

  public void heapify_up() {
    int index = this.size-1;

    while (has_parent(index) && parent(index) > this.items[index]) {
      swap(get_parent_index(index), index);
      index = get_parent_index(index);
    }
  }

  public void heapify_down() {
    int index = 0;
    while(has_left_child(index)) {
      int smaller_child_index = get_left_child_index(index);

      if (has_right_child(index) && right_child(index) < left_child(index)) {
        smaller_child_index = get_right_child_index(index);
      }

      if (items[index] < items[smaller_child_index]) { break; }
      else { swap(index, smaller_child_index); }

      index = smaller_child_index;
    }
  }
}
