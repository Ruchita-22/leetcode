package section7.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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
	
	
	public List<List<Integer>> combine(int n, int k) {
        res.clear();
        solve(n, k, 0, new ArrayList(2));
        return res;
    }
    private void solve(int n, int k, int pos, List<Integer> list) {

        if(pos == k) {
            res.add(new ArrayList(list));
            return;
        }

        for(int i = 1 ; i <= n; i++) {
            if(list.size() > 0 && i <= list.get(list.size()-1)) continue;  // controlled recursion  
            list.add(pos,i);
            solve(n, k, pos+1, list);
            list.remove(list.size()-1);
        }
    }
	////////////////////////////////////////////////////
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] arr) {
        res.clear();
        Arrays.sort(arr);
        solve(arr, arr.length, 0);
        return res;
    }
    private void solve(int arr[], int n, int pos) {
        if(pos == n) {
            res.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i = pos; i < arr.length; i++) {
            if (!shouldSwap(arr, pos, i)) continue;
            swap(arr, i, pos);
            solve(arr, n, pos+1);
            swap(arr, i, pos);
        }
    }
    private boolean shouldSwap(int[] arr, int start, int curr) {
        for (int i = start; i < curr; i++) {
            if (arr[i] == arr[curr]) return false;
        }
        return true;
    }

    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

	///////////////////////////////////////////////////////////////////////////////////
    //39. Combination Sum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res.clear();
        solve(candidates, 0, 0, target, new ArrayList());
        return res;

    }
    private void solve(int arr[], int pos, int currSum, int targetSum, List<Integer> list) {
        if(currSum == targetSum) {
            res.add(new ArrayList(list));
            return;
        }
        if(pos == arr.length || currSum > targetSum) {
            return;
        }
        // take
        currSum = currSum + arr[pos];
        list.add(arr[pos]);
        solve(arr, pos, currSum, targetSum,list);

        //not take
        currSum = currSum - arr[pos];
        list.remove(list.size()-1);
        solve(arr, pos+1,currSum, targetSum,list);

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
    //Largest number in K swaps
    private static void solve(int start, int k, String str, String res) {
    	
    	char max = str.substring(start + 1)
                .chars()
                .mapToObj(c -> (char) c)
                .max(Character::compareTo)
                .orElse('\0');
    	
    	if(k == 0 || start == str.length()) {
    		return;
    	}
    	for(int i = start+1; i < str.length(); i++) {
    		if(str.charAt(start) < str.charAt(i) && str.charAt(i) == max) {
    			swap(str, start, i);
    			if(str.compareTo(res) > 0) {
    				res = str;
    			}
    			solve(start+1, k-1, str, res);
    			swap(str, start, i);
    		}
    	}
    	solve(start+1,k, str, res); //horizontal drift of recursion
    }
    private static void swap(String str, int i, int j) {
    	char s[] = str.toCharArray();
    	char c = s[i];
    	s[i] = s[j];
    	s[j] = c;
    	str = new String(s);
    	
    }

}
