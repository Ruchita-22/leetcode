package string.trie;

public class TrieForXor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
	}
	//Q1. Maximum XOR
	public int solve(int[] arr) {
        TrieNode root = new TrieNode();
        for(int i = 0; i < arr.length; i++){
            insert(root,arr[i]);
        }

        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            ans = Math.max(ans,findMaxXor(root,arr[i]));
        }
        return ans;
    }
	
	
	////////Helper function//////////////////////
	static class TrieNode{
	    TrieNode children[] = new TrieNode[2];
	    int isEnd = 0;	
	}
    private static void insert(TrieNode root, int x){
        TrieNode curr = root;
        
        for(int i = 31; i >= 0; i--){       // left to right
            int currBit = checkBit(x,i);
            if(curr.children[currBit] == null){
                curr.children[currBit] = new TrieNode();
            }
            curr = curr.children[currBit];
        }
        curr.isEnd = 1;
    }
    //not needed
	private static int search(TrieNode root, int x) {
		TrieNode curr = root;
		for (int i = 31; i >= 0; i--) {
			int currBit = checkBit(x, i);
			if (curr.children[currBit] == null)		return 0;
			curr = curr.children[currBit];
		}
		return curr.isEnd;
	}
    private static int findMaxXor(TrieNode root,int x){
        TrieNode curr = root;
        int ans = 0;
        for(int i = 31; i >= 0; i--){
            if(curr == null)  break;
            if(checkBit(x,i) == 1){
                if(curr.children[0] != null) {  // go to 0 side
                    ans = ans | (1<<i);
                    curr = curr.children[0];
                }    
                else if(curr.children[1] != null)    curr = curr.children[1];
            }
            else{
                if(curr.children[1]!=null){
                    ans = ans | (1<<i);
                    curr = curr.children[1];
                }    
                else if(curr.children[0]!=null)    curr = curr.children[0];
            }
        }
        return ans;
    }
    
    private static int checkBit(int x, int i){
		if (((x >> i) & 1) == 1)  return 1;
        else return 0;
    }

}
