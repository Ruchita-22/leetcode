package section1.binary_serach;

public class BinarySearchInForest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Binary Search in forest
	private static int find_height(int arr[], int n, int k) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int l = 0, r = max;
		int ans = 0;
		while (l <= r) {
			int m = l + (r - l) / 2;
			int sum = sum(arr, m);
			if (sum == k)
				return m;
			else if (sum > k)
				l = m + 1;
			else if (sum < k)
				r = m - 1;
		}
		return -1;
	}

	private static int sum(int arr[], int h) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > h)
				sum = sum + arr[i] - h;
		}
		return sum;
	}

}
