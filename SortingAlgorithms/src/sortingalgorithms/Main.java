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
		arraySingleValue = new Integer[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
		
		implementation = new BubbleSort<>();
		// Instanciar outra classe que representa um algoritmo de ordenação, se quiser testar outro.
		// Exemplo: implementation = new QuickSort<>();
		
		printSortedArray(arrayEvenSize);
		// Trocar o parâmetro, caso queira testar outro array.
	}
	
	// Ordena um array do início ao fim, e o imprime.
	public static void printSortedArray(Integer[] array) {
		printSortedArray(array, 0, array.length - 1);
	}
	
	
	// Ordena um array de uma posição determinada a outra, e o imprime. 
	public static void printSortedArray(Integer[] array, int left, int right) {
		System.out.println("BEFORE SORTING: " + Arrays.toString(array));
		implementation.sort(array, left, right);
		System.out.println("AFTER SORTING: " + Arrays.toString(array));
	}

}
