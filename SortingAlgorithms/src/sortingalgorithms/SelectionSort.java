package sortingalgorithms;

public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) {
			int posMenor = i;
			for (int j = i + 1; j <= rightIndex; j++) {
				if (array[j].compareTo(array[posMenor]) < 0) posMenor = j;
			}
			Util.swap(array, i, posMenor);
		}
	}

}
