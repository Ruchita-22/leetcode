package section1.binary_serach;

public class AllocateBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Allocate Books
	public int books(int[] pages, int students) {
        if(pages.length<students) return -1;        // edge case
        
        long s = 0, e= 0;
        for(int p : pages){
            s = Math.max(s,p);
            e += p; 
        }
        long ans = 0;
        while(s<=e){
            long m = s+(e-s)/2;
            if(check(m, pages, students)){
                ans = m;
                e = m-1;
            }
            else{
                s = m+1;
            }
        }
        return (int) ans;
    }
    private static boolean check (long m, int[] pages, int students){
        long st = 1;			// student
        long tp = 0;			//total pages
        for(int p : pages){
            tp += p;
            if(tp>m){
                st++;
                tp = p;
            }
        }
        return st>students ?  false : true;
    }
}
