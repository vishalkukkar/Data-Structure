package com.example.arrayy;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.util.Util;

public class CampusCup {

	
	
	static String[] emails =  {"b@rain.ifmo.ru", 
			 "c@rain.ifmo.ru", 
			 "d@rain.ifmo.ru", 
			 "e@rain.ifmo.ru", 
			 "f@rain.ifmo.ru", 
			 "g@rain.ifmo.ru", 
			 "h@rain.ifmo.ru", 
			 "i@rain.ifmo.ru", 
			 "j@rain.ifmo.ru", 
			 "k@rain.ifmo.ru", 
			 "l@rain.ifmo.ru", 
			 "m@rain.ifmo.ru", 
			 "n@rain.ifmo.ru", 
			 "o@rain.ifmo.ru", 
			 "p@rain.ifmo.ru", 
			 "q@rain.ifmo.ru", 
			 "r@rain.ifmo.ru", 
			 "s@rain.ifmo.ru", 
			 "t@rain.ifmo.ru", 
			 "u@rain.ifmo.ru", 
			 "v@rain.ifmo.ru", 
			 "w@rain.ifmo.ru", 
			 "x@rain.ifmo.ru", 
			 "y@rain.ifmo.ru", 
			 "a@mit.edu.ru", 
			 "b@mit.edu.ru", 
			 "c@mit.edu.ru", 
			 "d@mit.edu.ru", 
			 "e@mit.edu.ru", 
			 "f@mit.edu.ru", 
			 "g@mit.edu.ru", 
			 "h@mit.edu.ru", 
			 "i@mit.edu.ru", 
			 "j@mit.edu.ru", 
			 "k@mit.edu.ru", 
			 "l@mit.edu.ru", 
			 "m@mit.edu.ru", 
			 "n@mit.edu.ru", 
			 "o@mit.edu.ru"};
	
	public static void main(String[] args) {
		System.out.println(campusCup(emails));
	}
	        		 
	static String[] campusCup(String[] emails) {

	    LinkedHashMap<String,Integer> temp = new LinkedHashMap<>();
	    for(String s : emails){
	       String[] array =  s.split("@");
	       String domain = array[1];
	       
	       if(temp.containsKey(domain)){
	           temp.put(domain,temp.get(domain) + 1);
	       }else{
	           temp.put(domain,1);
	       }
	    }
	    
	    
	    LinkedHashMap<String,Float> map = new LinkedHashMap<>();
	    
	    for(Map.Entry<String,Integer> m : temp.entrySet()){
	        Float data = getPoints(m.getValue());
	        map.put(m.getKey(),data);
	        System.out.println(m.getKey()+"  "+data);
	    }
	    
	    
	    String[] res = new String[map.size()];
	    List<Map.Entry<String,Float>> list =
	                new LinkedList<Map.Entry<String,Float>>(map.entrySet());

	        
		Collections.sort(list,new Comparator<Map.Entry<String,Float>>(){
				public int compare(Map.Entry<String,Float> o1,Map.Entry<String,Float> o2){
					
					if(o2.getValue().equals(o1.getValue())){
						return o1.getKey().compareTo(o2.getKey());
					}
					
					return o2.getValue().compareTo(o1.getValue());
				}
			});
	    
	    
	    int i = 0;
	    for (Map.Entry<String,Float> entry : list) {
	    	
	    	System.out.println(entry.getKey());
	        res[i] = entry.getKey();
	        i++;
	    }
	    
	    
	    return res;
	   
	}


	public static Float getPoints(Integer n){
	    
	    int points = n * 20;
	    Float data = 0f;
	    if(points >= 100){
	        data += 3 * n;
	    }
	    
	    if(points >= 200){
	        data += 8 * n;
	    }
	    
	     if(points >= 300){
	        data += 15 * n;
	    }
	    
	     if(points >= 500){
	        data += 25 * n;
	    }
	    
	    return data / n;
	}

}
