package sortingalgorithms;

public class Util {
	
	public static void swap(Object[] array, int i, int j) {
		if (array == null)
			throw new IllegalArgumentException("Array nulo!");
		
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
