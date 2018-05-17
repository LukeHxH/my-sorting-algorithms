package sortingalgorithms;

public class RadixSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (rightIndex > leftIndex) {
			int maxValue = getMaximumValue(array);

			for (int i = 1; (maxValue / i) > 0; i *= 10) count(array, i);
		}
	}

	private void count(Integer[] array, int digitPlace) {
		int[] count = new int[10];
		for (int i = 0; i < 10; i++) count[i] = 0;

		for(int value: array) count[getDigit(value, digitPlace)]++;
		
		for (int i = 1; i < 10; i++) count[i] += count[i - 1];
		
		int[] sorted = new int[array.length];
		for (int i = array.length - 1; i >= 0; i--) {
			sorted[count[getDigit(array[i], digitPlace)] - 1] = array[i];
			count[getDigit(array[i], digitPlace)]--;
		}
		
		for (int i = 0; i < array.length; i++) array[i] = sorted[i];
	}

	private int getMaximumValue(Integer[] array) {
		int m = array[0];
		for (int i = 1; i < array.length; i++)
			if (array[i] > m)
				m = array[i];
		return m;
	}
	
	private int getDigit(int value, int place) {
		return (value / place) % 10;
	}

}
