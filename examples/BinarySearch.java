import java.util.NoSuchElementException;

public class BinarySearch {

	public static void main(String[] args) {
		// Integer[] example = {10, 11, 12, 14, 15};
		Integer[] example = {10, 11, 12, 14};
		int index = binarySearch(example, 10);
		System.out.println("index: " + index);
	}

	public static <T extends Comparable<? super T>> int binarySearch(T[] arr, T item) {
		return binarySearch(arr, item, 0, arr.length);
	}	

	public static <T extends Comparable<? super T>> int binarySearch(T[] arr, T item, int low, int high) {

		if ( (high - low) <= 0) {
			throw new NoSuchElementException();
		}

		int mid = (high + low) / 2;

		int compare = item.compareTo(arr[mid]);
		if (compare == 0) {
			return mid;
		} else if (compare < 0) {
			return binarySearch(arr, item, low, mid);
		} else {
			return binarySearch(arr, item, mid, high);
		}
	}
}