package section4.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Backtracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Input output method
	// Recursion tree
	private static void printPowerSet(String in, String op) {
		// TODO Auto-generated method stub
		if (in.length() == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		op2 = op2 + in.charAt(0);
		in = in.substring(1);
		printPowerSet(in, op2);
		printPowerSet(in, op1);
		return;
	}

	private static void permuteWithSpace(String in, String op) {
		// TODO Auto-generated method stub
		if (in.length() == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		op1 = op1 + " " + in.charAt(0);
		op2 = op2 + in.charAt(0);
		in = in.substring(1);
		permuteWithSpace(in, op2);
		permuteWithSpace(in, op1);
		return;
	}

	private static void permuteWithCaseChange(String in, String op) {
		// TODO Auto-generated method stub
		if (in.length() == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		op1 = op1 + in.charAt(0);
		op2 = op2 + Character.toUpperCase(in.charAt(0));
		in = in.substring(1);
		permuteWithCaseChange(in, op2);
		permuteWithCaseChange(in, op1);
		return;
	}

	private static void letterChange(String in, String op) {
		// TODO Auto-generated method stub
		if (in.length() == 0) {
			System.out.println(op);
			return;
		}
		char ch = in.charAt(0);
		if (Character.isAlphabetic(ch)) {
			String op1 = op;
			String op2 = op;
			op1 = op1 + Character.toLowerCase(ch);
			op2 = op2 + Character.toUpperCase(ch);
			in = in.substring(1);
			letterChange(in, op1);
			letterChange(in, op2);
			return;

		} else {
			String op1 = op;
			op1 = op1 + ch;
			in = in.substring(1);
			letterChange(in, op1);
			return;

		}
	}

	////////////////////////////////////////////////////////
	static ArrayList<ArrayList<Integer>> res;
	static HashSet<ArrayList<Integer>> set;

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> arr) {
		res = new ArrayList<>();
		set = new HashSet<>();
		solve(arr, arr.size(), 0);

		return res;
	}

	private static void solve(ArrayList<Integer> arr, int n, int pos) {
		if (pos == n) {
			if (!set.contains(arr)) {
				ArrayList<Integer> t = new ArrayList<>(arr);
				set.add(t);
				res.add(t);
			}
			return;
		}
		for (int i = pos; i < n; i++) {
			swap(arr, i, pos);
			solve(arr, n, pos + 1);
			swap(arr, i, pos);
		}
	}

	private static void swap(ArrayList<Integer> arr, int i, int j) {
		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}

	///////////////////////////////////////////////////////////////////////////////////
	static ArrayList<ArrayList<Integer>> list;
	// static HashSet<ArrayList<Integer>> set;

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
		list = new ArrayList<>();
		set = new HashSet<>();
		Collections.sort(arr);
		solve(arr, sum, 0, 0, new ArrayList<>());
		return list;
	}

	private static void solve(ArrayList<Integer> arr, int sum, int pos, int currSum, ArrayList<Integer> temp) {
		if (pos == arr.size()) {
			if (currSum == sum && !set.contains(temp)) {
				ArrayList<Integer> t = new ArrayList<>(temp);
				set.add(t);
				list.add(t);
			}
			return;
		}
		// take
		currSum = currSum + arr.get(pos);
		temp.add(arr.get(pos));
		solve(arr, sum, pos + 1, currSum, temp);

		// dont take
		currSum = currSum - arr.get(pos);
		temp.remove(temp.size() - 1);
		solve(arr, sum, pos + 1, currSum, temp);

	}
	////////////////////////////////////////////
//	static ArrayList<ArrayList<Integer>> res;
//    static HashSet<ArrayList<Integer>> set;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> arr) {
        res = new ArrayList<>();
        set = new HashSet<>();
        
        Collections.sort(arr);
        solve(arr, arr.size(),0, new ArrayList<Integer>());
        
        Collections.sort(res, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2){
                int len = Math.min(l1.size(), l2.size());
                for(int i=0;i<len;i++){
                    if(l1.get(i)<l2.get(i)) return -1;
                    if(l1.get(i)>l2.get(i)) return 1;
                }
                if(l1.size()<l2.size()) return -1;
                if(l1.size()>l2.size()) return 1;
                return 0;
            }
        });
        
        return res;
    }
    private static void solve(ArrayList<Integer> arr, int n, int pos,ArrayList<Integer> temp){
        if(pos==n){
        	if(!set.contains(temp)){
        		//it will create a copy as temp is keep on changing
                ArrayList<Integer> t = new ArrayList<>(temp);
                set.add(t);
                res.add(t);
            }
            return;
        }
        temp.add(arr.get(pos));
        solve(arr,n, pos+1,temp);
        temp.remove(temp.size()-1);
        solve(arr, n, pos+1,temp);
    }


}
