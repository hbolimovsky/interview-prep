import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class MergeSort {

	public static void main(String[] args) {
		List<Integer> example = Arrays.asList(new Integer[]{5,3,1,4,2});
		System.out.println("before: " + example);
		example = mergeSort(example);
		System.out.println("after: " + example);
	}

	public static <T extends Comparable<? super T>> List<T> mergeSort(List<T> list) {

		if (list.size() <= 1) {
			return list;
		}

		int mid = list.size() / 2;
		List<T> left = list.subList(0, mid);
		List<T> right = list.subList(mid, list.size());

		left = mergeSort(left);
		right = mergeSort(right);

		return merge(left, right);
	}

	public static <T extends Comparable<? super T>> List<T> merge(List<T> left, List<T> right) {

		int leftIndex = 0;
		int rightIndex = 0;
		List<T> sorted = new ArrayList<T>();

		while ( (leftIndex < left.size()) && (rightIndex < right.size()) ) {

			if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
				sorted.add(left.get(leftIndex));
				leftIndex++;
			} else {
				sorted.add(right.get(rightIndex));
				rightIndex++;
			}
		}

		while (leftIndex < left.size()) {
			sorted.add(left.get(leftIndex));
			leftIndex++;
		}

		while (rightIndex < right.size()) {
			sorted.add(right.get(rightIndex));
			rightIndex++;
		}

		return sorted;
	}

}