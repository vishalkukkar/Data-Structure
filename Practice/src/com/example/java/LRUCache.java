package com.example.java;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

	private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	
    	System.out.print(String.format("get(%s) ",key ));
        if (!map.containsKey(key)) return -1;
        Integer val = map.get(key);
        put(key, val);
        
        
        /*for(Map.Entry<Integer, Integer> m : map.entrySet()){
			System.out.print(" "+m.getKey());
		}
        
        System.out.println("\n\n");*/
        
        return val;
    }
    
    public void put(int key, int value) {
    	System.out.println(String.format("put(%s) ",key));
        if (map.containsKey(key)) {
            map.remove(key);
        } 
        else if (map.size() == capacity) {
            map.remove(map.keySet().iterator().next());
        }
        
        map.put(key, value);
        
        
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
			System.out.print(" "+m.getKey());
		}
        
        System.out.println("\n\n");
    }

	public static void main(String[] args) {

		LRUCache cache = new LRUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);

		System.err.println(cache.get(1));// returns 1
		cache.put(3, 3); // evicts key 2

		System.err.println(cache.get(2)); // -1
		cache.put(4, 4); // evicts key 1
		System.err.println(cache.get(1)); // -1

		System.err.println(cache.get(3));
		System.err.println(cache.get(4)); // returns 4

	}
}
