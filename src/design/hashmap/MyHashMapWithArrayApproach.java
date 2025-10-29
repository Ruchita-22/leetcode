package design.hashmap;

public class MyHashMapWithArrayApproach {
	int l[];
    public MyHashMapWithArrayApproach() {
        l=new int[10000000];
    }
    
    public void put(int key, int value) {
        l[key]=value+1;
    }
    
    public int get(int key) {
        return l[key]-1;
    }
    
    public void remove(int key) {
        l[key]=0;
    }
}
