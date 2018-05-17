package sortingalgorithms;

public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (rightIndex > leftIndex) {
			Integer[] sorted = new Integer[array.length];
			
			Integer maxAndMin[] = maxAndMin(array, leftIndex, rightIndex);
			int min = maxAndMin[0];
			int max = maxAndMin[1];
			
			int count[] = new int[(max - min) + 1];
			for (int i = 0; i < count.length; i++) count[i] = 0;
			
			for (int num: array) count[num - min]++;
			
			int cumulativeSum = 0;
			for (int i = 0; i < count.length; i++) {
				cumulativeSum += count[i];
				count[i] = cumulativeSum;
			}
			
			for (int i = (count.length - 1); i > 0; i--) count[i] = count[i-1];
			count[0] = leftIndex;
			
			for (int i = leftIndex; i <= rightIndex; i++) {
				sorted[count[array[i] - min] + leftIndex] = array[i];
				count[array[i] - min]++;
			}
			
			for (int i = leftIndex; i <= rightIndex; i++) array[i] = sorted[i]; 
		}
	}
	
	private Integer[] maxAndMin(Integer[] array, int leftIndex, int rightIndex) {
		Integer max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > max) max = array[i];
			if (array[i] < min) min = array[i];
		}
		return new Integer[] {min, max};
	}

}
