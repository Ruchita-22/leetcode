package section1.binary_serach;

public class FoodPacketsDistribution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[] population, int office) {
		// B distribution office
		// population = city population

		long sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < population.length; i++) {
			sum += population[i];
			min = Math.min(min, population[i]);
		}
		if (sum < office)
			return 0;

		int l = 1, r = min;
		int ans = 0;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (check(population, office, m)) {
				ans = m;
				l = m + 1;
			} else
				r = m - 1;
		}
		return ans;

	}

	private static boolean check(int population[], int office, int tp) {
		int n = 0;
		for (int i = 0; i < population.length; i++) {
			n += population[i] / tp;
		}
		if (n >= office)
			return true;
		else
			return false;
	}

}
