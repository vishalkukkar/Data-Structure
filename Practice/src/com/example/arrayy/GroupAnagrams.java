package com.example.arrayy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class GroupAnagrams {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		String[] array = { "eat", "tea", "tan", "ate", "nat", "bat" };
		//String[] array2 = {"duh","ill"};
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(groupAnagrams(array)));
	}

	public static List<List<String>> groupAnagrams(String[] strs) 
			throws JsonGenerationException, JsonMappingException, IOException {
		List<List<String>> result = new ArrayList<List<String>>();
		 
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(String str: strs){
	        char[] arr = new char[26];
	        for(int i=0; i<str.length(); i++){
	            arr[str.charAt(i)-'a']++;
	        }
	        
	        String ns = new String(arr);
	        if(map.containsKey(ns)){
	            map.get(ns).add(str);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(str);
	            map.put(ns, al);
	        }
	    }
	 
	   
		
	    result.addAll(map.values());
	 
	    return result;
	}

}
