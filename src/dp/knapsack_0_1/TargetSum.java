package dp.knapsack_0_1;

public class TargetSum {
	static int t[][] = new int[21][1001];
	
    public static int findTargetSumWays(int[] a, int diff) {
    	System.out.println("findTargetSumWays");
        int sum = 0;
        for(int i = 0; i< a.length ; i++)
            sum += a[i];
        int W = (diff+sum)/2;
        return knapsack(a,W,a.length);
        
    }
    public static int knapsack (int[] a, int W, int n) {
        System.out.println("knapsack");
        //Base condition
        for(int i = 0; i< n+1 ; i++){
            for(int j = 0; j< W+1; j++){
                if( i == 0 )
                    t[i][j] = 0;
                if( j == 0 )
                    t[i][j] = 1;
            }
        }
        for(int i = 0; i < n+1 ; i++){
            for(int j = 0; j < W+1; j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
        //Choice diagram
        for(int i = 1; i< n+1 ; i++){
            for(int j = 1; j< W+1; j++){
               if(a[i-1] <= W)
                    t[i][j] = t[i-1][j-a[i-1]] + t[i-1][j];
                else
                   t[i][j] = t[i-1][j];
            }
        }
        for(int i = 0; i < n+1 ; i++){
            for(int j = 0; j < W+1; j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
        return t[n][W];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 1, 1, 1, 1};
		int diff = 3;
		System.out.println(findTargetSumWays(a,diff));
	}
}
