package section8b.grid.dp;

import java.util.*;

public class UniquePath {
	static Map<String, Integer> map = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		map.clear();
		System.out.println(uniquePath(0,0,m-1,n-1));

	}

	private static int uniquePath(int i, int j, int row, int col) {
		if(i == row || j == col)
			return 1;
		if(i > row || j > col)
			return 0;
		String key = i+"#"+j;
		if(map.containsKey(key))
			return map.get(key);
		
		int result =  uniquePath(i+1, j, row, col) + uniquePath(i, j+1, row, col);
		map.put(key, result);
		return result;
	}

}
