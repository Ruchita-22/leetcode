package section2.heap;

import java.util.Comparator;

public class MyComparator implements Comparator<Pair>
{
//    public int compare( Integer x, Integer y ) {
//  
//        return y - x;
//    }

	@Override
	public int compare(Pair o1, Pair o2) {
		//for ascending
		return o1.getKey()-o2.getKey();
		//for descending
		//return o2.getKey()-o1.getKey();
		
		
	}

}
