package section1.binary_serach;

import java.util.Arrays;

public class AggresiveCow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int solve(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int n=stalls.length;
        int l=1, r=stalls[n-1]-stalls[0];
        int ans=0;
        while(l<=r){
            int m = l+(r-l)/2;
            if(check(stalls,m,cows)){
                ans=m;
                l=m+1;
            }
            else 
                r=m-1;
        }
        return ans; 
    }
    private static boolean check(int stalls[],int m,int cows){
        int last_place = stalls[0];
        int count=1;
        for(int i=1;i<stalls.length;i++){
            if((stalls[i]-last_place)>=m){
                last_place=stalls[i];
                count++;
                if(count==cows)
                    return true;
            }
        }
        return false;
    }

}
