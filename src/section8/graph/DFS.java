package section8.graph;

public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static void dfsPrint(int[][] adj_matrix, int sv) {
		boolean visited[] = new boolean[adj_matrix.length];
		for (int i = 0; i < adj_matrix.length; i++) {
			if(adj_matrix[sv][i]==1 &&  visited[i] == false)
				dfs(adj_matrix, i, visited);
		}
	}
	
	
	////////////Helper//////
	private static void dfs(int[][] adj_matrix, int sv, boolean[] visited) {
		// TODO Auto-generated method stub
		System.out.println(sv);
		visited[sv] = true;
		for (int i = 0; i < adj_matrix.length; i++) {
			if(adj_matrix[sv][i] == 1 && visited[i] == false)
				dfs(adj_matrix, i,visited);
		}
	}
	

}
