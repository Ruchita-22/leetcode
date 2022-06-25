package section0c.bit_manuplication;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public int singleNumber(int[] arr) {
        
        int ans=0;
        for(int i : arr){
            ans = ans ^ i;
        }
        return ans;
        
    }

}
