package section4a.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 1007. Minimum Domino Rotations For Equal Row

	class Pair {
		int s, e;

		public Pair(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		public int getS() {
			return s;
		}

		public int getE() {
			return e;
		}
	}

	public int solve(int[][] arr) {
		if (arr.length == 0)
			return 0;
		if (arr.length == 1)
			return 1;
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);
		PriorityQueue<Pair> pq = new PriorityQueue<>(
				(o1, o2) -> o1.getE() != o2.getE() ? o1.getE() - o2.getE() : o1.getS() - o2.getS());
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			Pair p = new Pair(arr[i][0], arr[i][1]);
			if (pq.size() == 0) {
				pq.add(p);
				continue;
			}
			if (pq.peek().getE() <= p.getS()) {
				pq.poll();
			}

			pq.add(p);
		}

		return pq.size();
	}

}
