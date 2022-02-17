package grid.dfs;

public class SimpleDFSOnGraph {
	
	////////////////////////////////Depth First Traversal//////////////////////////////////
	private static void dfsPrint(int[][] adj_matrix, int sv) {
		boolean visited[] = new boolean[adj_matrix.length];
		for (int i = 0; i < adj_matrix.length; i++) {
			if(visited[i] == false)
				dfsPrintHelper(adj_matrix, i, visited);
			}
		}
		
		private static void dfsPrintHelper(int[][] adj_matrix, int sv, boolean[] visited) {
		// TODO Auto-generated method stub
			System.out.println(sv);
			visited[sv] = true;
			for (int i = 0; i < adj_matrix.length; i++) {
				if(adj_matrix[sv][i] == 1 && visited[i] == false)
					dfsPrintHelper(adj_matrix, i,visited);
			}
		}

}
