package scaler;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(solve(new int[] {3, 4, 4, 6}, new int[] {20, 4, 10, 2}));
	}
	
	private static int countPattern(String s) {
		//Input "00011011"
        int i = 0,j=0;
        String r = "";
        int count = 0;
        for(char c : s.toCharArray()) {
        	if(c=='0')
        		i++;
        	else 
        		j++;
            r=r+c;
            if(i==j){
                count++;
                r="";
            }
        }
        return count;
    }
	
	private static String longestSubsequenceOfVowel(String s) {
        String r="";
        for(char c: s.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                r = r+c;
            }
        }
        return r;
    }
	
	private static int solve1(int[] arr, int b) {
		//https://www.scaler.com/academy/mentee-dashboard/class/24512/assignment/problems/9992/?navref=cl_pb_nv_tb
        int c=0;
        boolean s=false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==b)
                s=true;
            if(arr[i]>b){
                arr[i]=-1;
                c++;
            }
        }
        if(s==true)
            return c;
        else
            return -1; 
    }
	
	private static int[] solve(int[] arr, int[] b) {
       
		int n=arr.length;
        int res[]=new int[n];
        
        for(int i=0;i<n;i++){
        	
        	int s=0,j=0,c=0;
        	
        	while(b[i]>s && j<n) {
        		s=s+arr[j];
        		c++;j++;
        		
        		
        	}
        	if(c==j)
        		res[i]=c;
        	else
        		res[i]=c-1;
        }
		return res;

    }
	
	private static void print(int arr[]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();

	}
	

}
