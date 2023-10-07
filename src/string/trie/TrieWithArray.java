package string.trie;

import java.util.ArrayList;

public class TrieWithArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// Spelling Checker
	public int[] solve(String[] dictionary, String[] query) {
        TrieNode root = new TrieNode();
        for(int i = 0; i < dictionary.length; i++){
            insert(root, dictionary[i]);
        }
        int res[] = new int[query.length];

        for(int i = 0; i < query.length; i++){
            res[i] = search(root, query[i]);
        }
        return res;
    }

    //Shortest Unique Prefix
    public String[] prefix(String[] dictionary) {
        TrieNode root = new TrieNode();
        for(int i = 0; i < dictionary.length; i++){
            insert(root, dictionary[i]);
        }
        String ans[] = new String[dictionary.length];
        for(int i = 0; i < dictionary.length; i++){
            ans[i] = prefix(root, dictionary[i]);
        }
        return ans;
    }
    //Contact Finder
    public int[] solve(int[] A, String[] B) {

        ArrayList<Integer> list = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(int i=0;i<A.length;i++){
            if(A[i]==0) insert(root, B[i]);
            else list.add(query(root,B[i]));
        }
        return list.stream().mapToInt(Integer :: intValue).toArray();
    }
    //Modified Search
    
    // Helper function
	static class TrieNode{
	    TrieNode children[];
	    int pf;
	    int isEnd;
	    public TrieNode() {
	        children = new TrieNode[26];
	        pf = 0;
	        isEnd = 0;
	    }
	}
    
    private static void insert(TrieNode root, String s){
        TrieNode curr = root;
        for(int i = 0; i < s.length(); i++){
            char ci = s.charAt(i);
            if(curr.children[ci-'a'] == null){
                curr.children[ci - 'a'] = new TrieNode();
            }
            curr = curr.children[ci-'a'];
            curr.pf++;
        }
        curr.isEnd = 1;
    }
    private static int search(TrieNode root, String s){
        TrieNode curr = root;
        for(int i = 0; i < s.length(); i++){
            char ci = s.charAt(i);
            if(curr.children[ci-'a'] == null)   return 0;
            curr = curr.children[ci-'a'];
        }
        return curr.isEnd;
    }    
    private static String prefix(TrieNode root, String s){
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ci = s.charAt(i);
            sb.append(ci);
            curr = curr.children[ci-'a'];
            if(curr.pf == 1)    break;
        }
        return new String(sb);
    }
    private static int query(TrieNode root, String str){
        TrieNode curr = root;

        for(char ci : str.toCharArray()){
            if(curr.children[ci - 'a'] == null){
                return 0;
            }
            curr = curr.children[ci - 'a'];
        }
        return curr.pf;
    }

}
