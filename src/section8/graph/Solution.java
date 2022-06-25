package section8.graph;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<>();
		canVisitAllRooms(list);

	}
	
	//127: word ladder
	private static void wordMatch(String temp, Map<String, Boolean> visited_map, Queue<String> queue) {
		for (int i = 0; i < temp.length(); i++) {
			char word[] = temp.toCharArray();
			for (int j = 0; j < 26; j++) {
				word[i] = (char) ('a'+j);
				String key = String.valueOf(word);
				if(visited_map.containsKey(key) && visited_map.get(key)==false) {
					queue.add(key);
					visited_map.put(key, true);
				}
					
			}
		}
		
	}
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord))	return 0;
		Map<String, Boolean> visited_map = new HashMap<String, Boolean>();
		Queue<String> queue = new LinkedList<String>();
		int level = 1;
		for (String key : wordList) {
			visited_map.put(key, false);
		}
		queue.add(beginWord);
		visited_map.put(beginWord, true);
		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				String temp = queue.poll();
				if(temp.equals(endWord))
					return level;
				wordMatch(temp, visited_map,queue);
			}
			level++;
		}
		return 0;
 
    }
	//841. Keys and Rooms
	 public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		 Queue<Integer> queue = new LinkedList<Integer>();
		 boolean visited[] = new boolean[rooms.size()];
		 visited[0] = true;
		 for (int i : rooms.get(0)) {
			 queue.add(i); 
			visited[i] = true;
		}
		 while (!queue.isEmpty()) {
			int front = queue.poll();
			for (int i : rooms.get(front)) {
				if(visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		 for (int i = 0; i < visited.length; i++) {
			if(visited[i] == false)
				return false;
		}
		return true;
	        
	 }

}
