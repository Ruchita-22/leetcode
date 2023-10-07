package section8.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class JobSequence {
	static class Job{
		int id;
		int deadline;
		int profit;
		public Job() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Job(int id, int deadline, int profit) {
			super();
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
		@Override
		public String toString() {
			return "Job [id=" + id + ", deadline=" + deadline + ", profit=" + profit + "]";
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Job arr[] = new Job[] {
				new Job(1,1,100),
				new Job(2,1,19),
				new Job(3,2,27),
				new Job(4,1,25),
				new Job(5, 1, 15)
				
			};
		print(JobScheduling(arr, arr.length));

	}
	
	//https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
	
	private static int[] JobScheduling(Job arr[], int n) {
		Arrays.sort(arr, (o1,o2)-> o1.profit != o2.profit ? o2.profit-o1.profit : o1.id-o2.id
				);
	
		boolean deadline[] = new boolean[100];
		int count=0;
		int profit=0;
		
		for(Job j : arr) {
			boolean flag = false;
			int index = j.deadline-1;
			while(flag==false && index>=0) {
				if(deadline[index]==false) {
					flag= true;
					deadline[index]=true;
					profit = profit+j.profit;
					count++;
				}
				else
					index--;
			}
			
		}
		int res[] = new int[] {count,profit};
		
		
		return res;
		
	}
	////////Helper Function//////////
	private static void print(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
    
}
