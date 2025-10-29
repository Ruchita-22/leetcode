package section15.design;

import java.util.ArrayList;

public class MyHashSet {
	static ArrayList<Integer> set;

    public MyHashSet() {
        set = new ArrayList<>();
        
    }
    
    public void add(int key) {
        if(!set.contains(key))
            set.add(key);
    }
    
    public void remove(int key) {
        if(set.contains(key))
            set.remove(set.indexOf(key));
    }
    
    public boolean contains(int key) {
        return set.contains(key);
    }
}
