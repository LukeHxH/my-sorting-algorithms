package sortingalgorithms;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	// Randomized pivot included!
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int indexPivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, indexPivot - 1);
			sort(array, indexPivot + 1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		int randomIndex = ThreadLocalRandom.current().nextInt(leftIndex, rightIndex + 1);
		int indexPivot = leftIndex;
		
		Util.swap(array, randomIndex, indexPivot);
		
		T pivot = array[leftIndex];
		
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i].compareTo(pivot) <= 0)
				Util.swap(array, i, ++indexPivot);
		}
		
		Util.swap(array, leftIndex, indexPivot);
		return indexPivot;
	}

}
