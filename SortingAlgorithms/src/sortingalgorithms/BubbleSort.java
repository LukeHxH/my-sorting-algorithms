package sortingalgorithms;

public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = 0; i < ((rightIndex - leftIndex) + 1); i++) {
			for (int j = leftIndex; j < rightIndex; j++) {
				if (array[j].compareTo(array[j+1]) > 0) {
					Util.swap(array, j, j+1);
				}
			}
		}
	}
}
