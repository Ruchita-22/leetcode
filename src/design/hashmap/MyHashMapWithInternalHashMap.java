package design.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MyHashMapWithInternalHashMap {

	
	    private Map<Integer, Integer> obj;

	    public MyHashMapWithInternalHashMap() {
	        obj = new HashMap<>();
	    }

	    public void put(int key, int value) {
	        obj.put(key, value);
	    }

	    public int get(int key) {
	        if (obj.containsKey(key)) {
	            return obj.get(key);
	        } else {
	            return -1;
	        }
	    }

	    public void remove(int key) {
	        obj.remove(key);
	    }
	
}
