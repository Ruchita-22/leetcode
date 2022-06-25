package section8b.grid.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DungeonGame {
	public static void main(String[] args) {
		int dungeon[][] =  {{-2,-3,3},{-5, -10, 1},{10,30,-5}};
		System.out.println(calculateMinimumHP(dungeon));

	}
	public static int calculateMinimumHP(int[][] dungeon) {
		if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
			return 0;
		Map<String, Integer> map = new HashMap<>();
		return helper(0,0,dungeon,map);
		
        
    }
	private static int helper(int row, int col, int[][] dungeon,Map<String, Integer> map) {
		// TODO Auto-generated method stub
		//base condition 
		if(row >= dungeon.length || col >= dungeon[0].length )
			return Integer.MAX_VALUE;

		String key = row+"and"+col; 
		if(map.containsKey(key))
			return map.get(key);
		
		//decision tree
		int health = Math.min(helper(row+1, col, dungeon,map), helper(row, col+1, dungeon,map));
		
		if(health == Integer.MAX_VALUE)
			health = 1;
		
		int result = Math.max(health - dungeon[row][col], 1);
		map.put(key, result);
		return result;
		
	}

}
