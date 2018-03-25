class Node {
  Node left, right;
  int data;
  public Node(int data) { this.data = data; }

  public void insert (int value) {
    if (value <= this.data) {
      if (this.left == null) { this.left = new Node(value); }
      else { this.left.insert(value); }
    } else {
      if (this.right == null) { this.right = new Node(value); }
      else { this.right.insert(value); }
    }
  }

  public boolean contains(int value) {
    if (value == this.data) { return true; }
    if (value < data) {
      if (this.left == null) { return false; }
      else { return this.left.contains(value); }
    } else {
      if (this.right == null) { return false; }
      else { return this.right.contains(value); }
    }
  }

  public void print_in_order() {
    if (this.left != null) {
      this.left.print_in_order();
    }

    System.out.println(this.data);

    if (this.right != null) {
      this.right.print_in_order();
    }
  }

  public void pre_order() {
    Sysem.out.println(this.data);

    if (this.left != null) {
      this.left.pre_order();
    }

    if (this.right != null) {
      this.right.pre_order();
    }
  }

  public void post_order() {
    if (this.left != null) {
      this.left.pre_order();
    }

    if (this.right != null) {
      this.right.pre_order();
    }

    Sysem.out.println(this.data);
  }
}
