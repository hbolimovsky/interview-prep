import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		
		Integer[] example = {5,3,1,4,2};
		System.out.println("before: " + Arrays.toString(example));
		insertionSort(example);
		System.out.println("after: " + Arrays.toString(example));
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {

		for (int currentIndex = 1; currentIndex < arr.length; currentIndex++) {

			T current = arr[currentIndex];

			int i;
			for (i = currentIndex; i > 0 && current.compareTo(arr[i-1]) < 0; i--) {
				arr[i] = arr[i-1];
			}
			arr[i] = current;
		}
	}
}