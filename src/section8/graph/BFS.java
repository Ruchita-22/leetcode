package section8.graph;

import java.util.*;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Input
		 ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		 adj.add(new ArrayList<>(Arrays.asList(5,4)));
		 adj.add(new ArrayList<>(Arrays.asList(0,1)));
		 adj.add(new ArrayList<>(Arrays.asList(0,2)));
		 adj.add(new ArrayList<>(Arrays.asList(0,3)));
		 adj.add(new ArrayList<>(Arrays.asList(2,4)));
		 
		 System.out.println(bfsOfGraph(0, adj));
	}
	static ArrayList<Integer> res = new ArrayList<Integer>();
	public static ArrayList<Integer> bfsOfGraph(int src, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.get(0).get(0);
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
        	input.add(i,new ArrayList<>());
        }
        
        for(int i=1;i<n;i++){
            int start = adj.get(i).get(0);
            int destination = adj.get(i).get(1);
            ArrayList<Integer> temp = input.get(start);
            temp.add(destination);
            input.set(start,temp);

        }
        
        res.clear();
        
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);
        for(int i=0;i<n;i++){
            if(visited[i]==false)
                bfs(input,i,visited);
        }
       // System.out.println(res);
        return res;
        
    }
	
	private static void bfs(ArrayList<ArrayList<Integer>> adj,int src,boolean visited[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		visited[src] = true;
		while(q.size()>0) {
			int node = q.poll();
			res.add(node);
			for(Integer v :  adj.get(src)) {
				if(visited[v]==false) {
					visited[v]=true;
					q.add(v);
				}
			}
		}	
	}
	static class Node{
		int val;
		int parent;
		
		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Node(int val, int parent) {
			super();
			this.val = val;
			this.parent = parent;
		}
		
	}
	private static boolean isCycle(ArrayList<ArrayList<Integer>>adj,int s) {
		int n = adj.size();
		Queue<Node> q = new LinkedList<>();
		boolean visited[] = new boolean[n+1];
		
		q.add(new Node(s,-1));
		visited[s]=true;
		
		while(q.size()>0) {
			Node current = q.poll();
			for(Integer v :  adj.get(current.val)) {
				if(visited[v]==false && )
			}
				
			
		}
		
		return false;
	}
	
}
