package section0c.bit_manuplication;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//136. Single Number
	public int singleNumber1(int[] arr) {
        int res = 0;
        for(int e : arr)    res ^= e;
        
        return res;
        
    }
	//260. Single Number III
	public int[] singleNumber3(int[] arr) {
        int res = 0;
        
        for(int e : arr)    res ^= e;
        
        int pos = 0; 
        for(int i = 0; i < 32; i++) {
            if(((res>>i)&1)==1) {
                pos = i;
                break;
            }
        }
        int set = 0, unset = 0;
        
        for(int  e : arr) {
            if(((e >> pos) & 1) == 1) set ^= e;
            else unset ^= e;
        }
        return new int[]{set, unset};
        
    }
	//137. Single Number II
	public int singleNumber(int[] arr) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;
            for(int j = 0; j < arr.length; j++){
                if(((arr[j]>>i) & 1) == 1)
                    sum++;
            }
            sum = sum % 3;
            if(sum != 0)
                ans |= sum << i; 
        }
        return ans;
    }

}
