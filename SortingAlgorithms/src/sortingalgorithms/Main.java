package sortingalgorithms;

import java.util.Arrays;

public class Main {
	
	private static Integer[] arrayEvenSize;
	private static Integer[] arrayOddSize;
	private static Integer[] emptyArray;
	private static Integer[] arrayWithRepeatedElements;
	private static Integer[] arraySingleValue;
	
	private static AbstractSorting<Integer> implementation;

	public static void main(String[] args) {
		arrayEvenSize = new Integer[] {10, 8, 12, 5, 2, 9, 3, 7, -2, 4};
		arrayOddSize = new Integer[] {10, 8, 12, 5, 2, 9, 3, 7, 1, -2};
		arrayWithRepeatedElements = new Integer[] {5, 2, 6, 8, 7, 5, 6, 1, 3, 5, 4, -2};
		emptyArray = new Integer[] {};
		
		implementation = new BubbleSort<>();
		/* Change this to test a sorting algorithm.
		 * 
		 * For example: implementation = new QuickSort<>();
		 * */
		
		printSortedArray(arrayEvenSize, 2, 6);
		// Change this if you want to test another arrray.
	}
	
	// Sorts an array from first index to last
	public static void printSortedArray(Integer[] array) {
		printSortedArray(array, 0, array.length - 1);
	}
	
	// Sorts an array from an index to other.
	public static void printSortedArray(Integer[] array, int left, int right) {
		System.out.println("BEFORE SORTING: " + Arrays.toString(array));
		implementation.sort(array, left, right);
		System.out.println("AFTER SORTING: " + Arrays.toString(array));
	}

}
