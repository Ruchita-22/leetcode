package section0a.star;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//upperTriangle1(5);
		//System.out.println("running");
		star(15);

	}
	private static void star(int n) {
		for (int i = 1; i <=n; i++) {
			for (int j = i; j <= n; j++) {
				System.out.print("*");
			}
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

//	private static void lowerTriangle(int n) {
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//	}
//	private static void upperTriangle1(int n) {
//		for (int i = 0; i < n; i++) {
//			for (int j = n-1-i; j >= 0; j--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//	}
//	private static void upperTriangle(int n) {
//		for (int i = n; i >=0; i--) {
//			for (int j = n; j >i; j--) {
//				System.out.print(" ");
//			}
//			for (int j = 0; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//	}

}
