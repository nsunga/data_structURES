import java.util.Arrays;

public class HashFunction {
  String[] the_array;
  int array_size;
  int items_in_array = 0;

  public static void main(String[] args) {
    HashFunction the_func = new HashFunction(30);
    // String[] elements_to_add = {"1", "5", "17", "21", "26"};
    // the_func.hash_function1(elements_to_add, the_func.the_array);
    String[] elements_to_add2 = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };

    the_func.hash_function2(elements_to_add2, the_func.the_array);

    the_func.find_key("660");

    the_func.display_the_stack();
  }

  public void hash_function1(String[] strings_for_array, String[] the_array) {
    for (int i = 0; i < strings_for_array.length; i++) {
      String new_element_value = strings_for_array[i];
      the_array[Integer.parseInt(new_element_value)] = new_element_value;
    }
  }

  public void hash_function2(String[] strings_for_array, String[] the_array) {
    for (int i = 0; i < strings_for_array.length; i++) {
      String new_element_value = strings_for_array[i];
      int array_index = Integer.parseInt(new_element_value) % 29;
      System.out.println("Modulus Index= " + array_index + " for value " + new_element_value);

      while (the_array[array_index] != "-1") {
        array_index++;
        System.out.println("Collision Try " + array_index + " Instead");

        array_index %= array_size;
      }

      the_array[array_index] = new_element_value;
    }
  }

  public String find_key(String key) {
    int array_index_hash = Integer.parseInt(key) % 29;

    while (the_array[array_index_hash] != "-1") {
      if (the_array[array_index_hash] == key) {
        System.out.println(key + " was Found in Index " + array_index_hash);
        return the_array[array_index_hash];
      }
      array_index_hash++;

      array_index_hash %= array_size;
    }

    return null;
  }

  public HashFunction(int size) {
    this.array_size = size;
    this.the_array = new String[size];
    Arrays.fill(the_array, "-1");
  }

  public void display_the_stack() {
		int increment = 0;

		for (int m = 0; m < 3; m++) {
			increment += 10;

			for (int n = 0; n < 71; n++) { System.out.print("-"); }

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {
        System.out.format("| %3s " + " ", n);
      }

			System.out.println("|");

			for (int n = 0; n < 71; n++) { System.out.print("-"); }

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {
				if (the_array[n].equals("-1")) { System.out.print("|      "); }
				else { System.out.print(String.format("| %3s " + " ", the_array[n])); }
			}

			System.out.println("|");

			for (int n = 0; n < 71; n++) { System.out.print("-"); }

			System.out.println();

		}

	}
}
