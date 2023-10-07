package section8.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 1007. Minimum Domino Rotations For Equal Row
	
	
	//Meeting Room
	static class Pair{
        int start;
        int end;
        
		public Pair() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Pair(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
    }
    public static int maxMeetings(int start[], int end[], int n)
    {	
        PriorityQueue<Pair> q = new PriorityQueue<>(n,
        		(o1,o2)-> o1.end != o2.end ? o1.end-o2.end : o1.start-o2.start);
        
        for(int i=0;i<n;i++) {
        	q.add(new Pair(start[i],end[i]));
        }
        int count=1;
        Pair last = q.poll();
        while(q.size()>0) {
        	Pair current = q.peek();
        	if(last.end<=current.start) {
        		count++;
        		last = current;
        	}
        	q.poll();
        }
        
        return count;
    }

}
