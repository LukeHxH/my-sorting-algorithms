package sortingalgorithms;

public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middleIndex = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middleIndex);
			sort(array, middleIndex + 1, rightIndex);
			
			merge(array, leftIndex, middleIndex, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
		Object[] aux = new Object[array.length];
		for (int i = 0; i < array.length; i++) aux[i] = array[i];
		
		int i = leftIndex;
		int j = middleIndex + 1;
		int k = leftIndex;
		
		while (i <= middleIndex && j <= rightIndex) {
			T elementLeft = (T) aux[i];
			T elementRight = (T) aux[j];
			
			if (elementLeft == null || elementRight == null)
				throw new NullPointerException("Array com elementos nulos.");
			
			if (elementLeft.compareTo(elementRight) <= 0) {
				array[k] = elementLeft;
				i++;
			} else {
				array[k] = elementRight;
				j++;
			}
			k++;
		}
		
		while (i <= middleIndex)
			array[k++] = (T) aux[i++];
		while (j <= rightIndex)
			array[k++] = (T) aux[j++];
	}
}
