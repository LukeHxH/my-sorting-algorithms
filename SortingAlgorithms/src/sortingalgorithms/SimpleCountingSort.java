package sortingalgorithms;

public class SimpleCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (rightIndex > leftIndex && inBounds(array, leftIndex) && inBounds(array, rightIndex)) {
			Integer[] sorted = new Integer[array.length];
			int max = max(array, leftIndex, rightIndex);
			
			int count[] = new int[max+1];
			for (int i = 0; i < count.length; i++) count[i] = 0;
			
			for (int i = leftIndex; i <= rightIndex; i++)
				count[array[i]]++;
			
			int total = 0;
			for (int i = 0; i <= max; i++) {
				int c = count[i];
				count[i] = total;
				total+= c;
			}
			
			for (int i = leftIndex; i <= rightIndex; i++) {
				sorted[count[array[i]] + leftIndex] = array[i];
				count[array[i]]++;
			}
			
			for (int i = leftIndex; i <= rightIndex; i++) array[i] = sorted[i];
		}
	}
	
	private Integer max(Integer[] array, int leftIndex, int rightIndex) {
		Integer max = Integer.MIN_VALUE;
		for (int i = leftIndex; i <= rightIndex; i++)
			if (array[i] > max) max = array[i];
		return max;
	}
	
	private boolean inBounds(Integer[] array, int index) {
		return index >= 0 && index < array.length;
	}

}
