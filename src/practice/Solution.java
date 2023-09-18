package practice;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbbbbbbbbb";
		char arr[] = s.toCharArray();
		System.out.println(solve1(s)); 
		System.out.println(solve1(s).length());
	}
	private static String solve(String str) {
		String res = ""+str.charAt(0);
		for(int i=1;i<str.length();i++) {
			char curr = str.charAt(i);
			char prev = str.charAt(i-1);
			if(curr != prev) {
				res = res+curr;				
			}
			
		}
		return res;
	}
	private static String solve1(String str) {
		String res = ""+str.charAt(0);
		int count = 1;
		for(int i=1;i<str.length();i++) {
			char curr = str.charAt(i);
			char prev = str.charAt(i-1);
			if(curr != prev) {
				if(count>1)	res = res+count;
				
				res = res+curr;	
				count = 1;
			}
			else count++;	
		}
		if(count>1)	res = res+count;
		return res;
	}
    private static int solve(char arr[]) {
        int k=0, count = 1;

        arr[k] = arr[0];
        k++;
		for(int i=1;i<arr.length;i++) {
			char curr = arr[i];
			char prev = arr[i-1];
			if(curr != prev) {
				if(count>1)	{
                    int no_of_digit = 0;
                    int temp_count = count;
                    while(temp_count>0){
                        no_of_digit++;
                        temp_count = temp_count/10;
                    }
                    int k1=k;
                    while(no_of_digit>0){
                        int digit = count % 10;
                        count = count/10;
                        arr[k1 + no_of_digit - 1] = (char)(digit+'0');
                        no_of_digit--;
                        k++; 
                    }
                    
                }
                arr[k] = curr;
                k++;
                
				count = 1;
			}
			else count++;	
		}
		if(count>1)	{
            int no_of_digit = 0;
            int temp_count = count;
            while(temp_count>0){
                no_of_digit++;
                temp_count = temp_count/10;
            }
            int k1=k;
            while(no_of_digit>0){
                int digit = count % 10;
                count = count/10;
                arr[k1+no_of_digit-1] = (char)(digit+'0');
                no_of_digit--;
                k++; 
            }
                    
        }
		return k;
	}
}
