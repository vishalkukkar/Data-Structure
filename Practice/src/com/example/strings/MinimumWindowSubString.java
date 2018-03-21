package com.example.strings;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class MinimumWindowSubString {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		String s = "ADOBECODEBANC";
		String t = "ABC";
		Long start = System.currentTimeMillis();
		System.out.println("res"+minWindow(s, t));
		System.out.println(System.currentTimeMillis() - start);
	}

	public static String minWindow(String s, String t) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper o = new ObjectMapper();
		 HashMap<Character,Integer> map = new HashMap<>();
		    for(char c : s.toCharArray())
		        map.put(c,0);
		    for(char c : t.toCharArray())
		    {
		        if(map.containsKey(c))
		            map.put(c,map.get(c)+1);
		        else
		            return "";
		    }
		    
		    int start =0, end=0, minStart=0,minLen = Integer.MAX_VALUE, counter = t.length();
		    while(end < s.length())
		    {
		        char c1 = s.charAt(end);
		        if(map.get(c1) > 0)
		            counter--;
		        map.put(c1,map.get(c1)-1);
		        
		        end++;
		        
		        System.out.println("before "+o.writeValueAsString(map)+"   counter "+counter+" char "+c1);
		        while(counter == 0)
		        {
		        	
		        	System.out.print("end "+end+" start "+start);
		            if(minLen > end-start)
		            {
		            	System.out.print("   end - start "+(end - start));
		                minLen = end-start;
		                minStart = start;
		            }
		            
		            
		            System.out.println("start char "+s.charAt(start));
		            char c2 = s.charAt(start);
		            map.put(c2, map.get(c2)+1);
		            System.out.println("counter "+counter);
		            if(map.get(c2) > 0)
		                counter++;
		            
		            start++;
		            

			        System.out.println("after  "+o.writeValueAsString(map)+"\n"+"start "+start+"\n\n");
		        }
		        
		    }
		    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
	}
}
