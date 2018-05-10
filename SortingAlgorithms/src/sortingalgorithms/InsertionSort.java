package sortingalgorithms;

public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) {
			int j = i - 1;
			T valor = array[i];
			
			while (j >= 0 && array[j].compareTo(valor) > 0) {
				Util.swap(array, j, j+1);
				j -= 1;
			}
		}
	}
}
