package section1.binary_serach;

public class PaintersPartitionProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int paint(int painters, int b, int[] board) {
        long s = 0,e = 0;
        for(int i=0;i<board.length;i++){
            s = Math.max(s,board[i]);
            e = e + board[i]; 
        }
        s = s * b;
        e = e * b;
        long ans = 0;

        while(s<=e){
            long m = s+(e-s)/2;
            if(check(m,painters, b, board)<=painters){
                ans = m;
                e = m-1;
            }
            else{
                s = m+1;
            }
        }
        return (int)(ans%10000003);
    }
    private static long check(long m, int painters, int b, int[] board ){
        long time = 0;
        long worker = 1;
        for(int l : board){
            time = time + l*1L*b;       // here it was getting over flow
            if(time>m){
                worker++;
                time = l*b;
            }
        }
        return worker;
    }
}
