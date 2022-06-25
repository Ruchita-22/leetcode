package section5.dp.unboundKnapsack;

public class MinCostTickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int days[] = {1,2,3,4,5,6,7,8,9,10,30,31};
		int costs[] = {2,7,15};
		System.out.println(mincostTickets(days,costs));

	}
	public static int mincostTickets(int[] days, int[] costs) {
		
		return knapsack(days,costs,days.length);
		
        
    }
	private static int knapsack(int[] days, int[] costs, int n) {
		// TODO Auto-generated method stub
		//Base condition
		if(n==0)
			return 0;
		
		return 0;
	}

}
/*It is asking minimal
 * choice on which day to buy pass
 * unlimited suffy of pass
 * so we can applay unbound knapsack
 * */
 