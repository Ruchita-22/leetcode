package concept;

import java.util.*;

public class Collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
	private static void _2DArray() {
		// Input list
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 3, 2),
                Arrays.asList(1, 2, 2),
                Arrays.asList(1, 2)
        );
 
        int[][] arr = list.stream().map(
        				l -> l.stream().
        				mapToInt(Integer::intValue).
        				toArray()
        			)
                	.toArray(int[][]::new);
 
        System.out.println(Arrays.deepToString(arr));
	}

}
