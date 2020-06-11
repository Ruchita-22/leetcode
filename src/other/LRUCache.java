package other;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
	private LinkedHashMap<Integer, Integer> linkedHashMap; 
    private final int CAPACITY; 
    public LRUCache(int capacity) 
    { 
        CAPACITY = capacity; 
        linkedHashMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) { 
            protected boolean removeEldestEntry(Map.Entry eldest) 
            { 
                return size() > CAPACITY; 
            } 
        }; 
    } 
    
    public int get(int key) {
		return linkedHashMap.getOrDefault(key, -1);
        
    }
    
    public void put(int key, int value) {
    	linkedHashMap.put(key, value);
        
    }
}