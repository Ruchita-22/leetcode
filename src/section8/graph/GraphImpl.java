package section8.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter number of vertex");
		int number_of_vertex = scanner.nextInt();
		
		System.out.println("enter number of edge");
		int number_of_edge = scanner.nextInt();
		
		int adj_matrix[][] = new int[number_of_vertex][number_of_vertex];
		
		for (int i = 0; i < number_of_edge; i++) {
			int sv = scanner.nextInt();
			int ev = scanner.nextInt();
			adj_matrix[sv][ev] = 1;
			adj_matrix[ev][sv] = 1;
		}
		dfsPrint(adj_matrix,0);
	}
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
///////////////////////////////Breath First traversal//////////////////////////////////////
	private static void bfsPrint(int[][] adj_matrix, int sv) {
		boolean visited[] = new boolean[adj_matrix.length];
		for (int i = 0; i < visited.length; i++) {
			if(visited[i] == false)
				bfsPrintHelper(adj_matrix, i, visited);
		}
	}
	//sv=source vertex   cn=current vertex
	private static void bfsPrintHelper(int[][] adj_matrix, int sv, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(sv);
		visited[sv] = true;
		while (!queue.isEmpty()) {
			int cv = queue.poll();
			System.out.println(cv);
			for (int i = 0; i < adj_matrix.length; i++) {
				if(adj_matrix[cv][i] == 1 && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}	
		}
	}
}
	

