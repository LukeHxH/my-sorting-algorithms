package sortingalgorithms;

import java.util.concurrent.ThreadLocalRandom;

public class ThreeWayQuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (rightIndex > leftIndex) {
			int indexPivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, indexPivot - 1);
			sort(array, indexPivot + 1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		int randomIndex = ThreadLocalRandom.current().nextInt(leftIndex, rightIndex + 1);
		Util.swap(array, randomIndex, leftIndex);
		
		int lessWall = leftIndex, wall = leftIndex;
		T pivot = array[leftIndex];
		
		for (int i = (leftIndex + 1); i <= rightIndex; i++ ) {
			if (array[i].compareTo(pivot) < 0) {
				Util.swap(array, i, ++wall);
				Util.swap(array, wall, ++lessWall);
			}
			
			if (array[i].compareTo(pivot) == 0)
				Util.swap(array, i, ++wall);
		}
		Util.swap(array, leftIndex, lessWall);
		Util.swap(array, lessWall, wall);
		return wall;
	}

}
