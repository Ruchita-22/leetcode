package section0d.array.prefixSum;

//304. Range Sum Query 2D - Immutable
public class NumMatrix {
    int mat[][],prefix[][];
    public NumMatrix(int[][] matrix) {
        mat = matrix;
        prefix = constructPf(mat);
    }
    
    public int sumRegion(int a1, int b1, int a2, int b2) {
        int sum = prefix[a2][b2];
        if(a1>0)
            sum -= prefix[a1-1][b2];
        if(b1>0)
            sum -= prefix[a2][b1-1];
        if(a1>0 && b1>0)
            sum += prefix[a1-1][b1-1];
        return sum;
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int pf[][] = constructPf(mat);
        
        int n=mat.length;
        int m=mat[0].length;
        
        int ans[][] = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                int a1=i-k;
                int b1=j-k;
                int a2=i+k;
                int b2=j+k;
                if(a2>n-1)
                    a2=n-1;
                if(b2>m-1)
                    b2=m-1;
                int sum = pf[a2][b2];
                if(a1>0)
                    sum -= pf[a1-1][b2];
                if(b1>0)
                    sum -= pf[a2][b1-1];
                if(a1>0 && b1>0)
                    sum += pf[a1-1][b1-1];
                ans[i][j] = sum;
                
            }
        }
        return ans;
    }
    private static int[][] constructPf(int mat[][]){
        int n=mat.length;
        int m=mat[0].length;
        int pf[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0)
                    pf[i][j]=mat[i][j];
                else 
                    pf[i][j]=pf[i][j-1]+mat[i][j];
            }
        }
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                pf[i][j] = pf[i-1][j]+pf[i][j];
            }
        }
        return pf;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

