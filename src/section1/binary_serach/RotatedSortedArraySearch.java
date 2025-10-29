package section1.binary_serach;

public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Q2. Rotated Sorted Array Search
	private static int searchInRoatatedArray(final int[] arr, int target) {
		
		int n = arr.length;
		int por = findValley(arr, n);
		if (target > arr[n - 1])
			return binaraySearch(arr, 0, por - 1, target);
		else
			return binaraySearch(arr, por, n - 1, target);

	}

	private static int findValley(int arr[], int n) {

		if (n == 1)
			return 0;
		if (arr[0] > arr[1])
			return 1;
		if (arr[n - 1] < arr[n - 2])
			return n - 1;

		int l = 0, r = n - 1;

		while (l <= r) {
			int m = l + (r - l) / 2;
			if (m == 0) {
				if (arr[m] < arr[m + 1])
					return m;
			}
			if (arr[m - 1] >= arr[m] && arr[m] <= arr[m + 1])
				return m;
			else if (arr[m] > arr[n - 1])
				l = m + 1;
			else
				r = m - 1;
		}
		return -1;
	}

	private static int binaraySearch(int arr[], int start, int end, int target) {
		int l = start, r = end;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (arr[m] == target)
				return m;
			else if (arr[m] > target)
				r = m - 1;
			else
				l = m + 1;

		}
		return -1;
	}

}
