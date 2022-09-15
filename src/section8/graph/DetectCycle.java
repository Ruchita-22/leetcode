package section8.graph;

public class DetectCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static boolean dectecCycle(int matrix[][],int sv) {
		int n= matrix.length;
		boolean visited[] = new boolean[n];
		
		for(int i=0;i<matrix.length;i++) {
			if(matrix[sv][i]==1 && visited[i]==false) {
				dfs(matrix,i,visited);
			}
		}
	}
}
