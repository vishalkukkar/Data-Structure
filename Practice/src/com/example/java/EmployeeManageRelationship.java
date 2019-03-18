package com.example.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.util.Util;

public class EmployeeManageRelationship {

	static Map<String, Integer> result = new HashMap<String, Integer>();

	/***
	 * 
	 * @param args
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * 
	 *  In this example C is manager of A, 
		C is also manager of B, F is manager 
		of C and so on.


A - 0  
B - 0
C - 2
D - 0
E - 1
F - 5 

	 */
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		Map<String, String> dataSet = new HashMap<String, String>();
		dataSet.put("A", "C");
		dataSet.put("B", "C");
		dataSet.put("C", "F");
		dataSet.put("D", "E");
		dataSet.put("E", "F");
		dataSet.put("F", "F");

		//populateResult(dataSet);
		calculate(dataSet);
	//	System.out.println("result = " + result);

	}
	

	private static void calculate(Map<String, String> dataSet) {
		
		Map<String,List<String>> map = new HashMap<>();
		Map<String,Integer> res = new HashMap<>();
		
		for(Map.Entry<String, String> entry : dataSet.entrySet()){
			
			
			if(entry.getKey().equals(entry.getValue()))
				continue;
			if(!map.containsKey(entry.getValue()))
				map.put(entry.getValue(), new ArrayList<>());
			map.get(entry.getValue()).add(entry.getKey());
		}
		
		Set<String> set = dataSet.keySet();
		
		for(String s : set){
			getCount(s,res,map);
		}
		System.out.println(Util.print(res));
	}



	private static int getCount(String key, Map<String, Integer> res, Map<String, List<String>> map) {
		
		
		
		List<String> list = map.get(key);
		
		if(list == null || list.size() == 0){
			res.put(key, 0);
			return 0;
			
		}
		
		int count = list.size();
		for(String s : list){
			
			if(res.get(s) != null){
				count += res.get(s);
			}else{
				count+= getCount(key, res, map);
			}
			res.put(key, count);
		}
		
		
		return count;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private static void populateResult(Map<String, String> dataSet)
			throws JsonGenerationException, JsonMappingException, IOException {

		Map<String, List<String>> relations = new HashMap<>();

		for (Map.Entry<String, String> entry : dataSet.entrySet()) {

			
			if(entry.getKey().equals(entry.getValue())) continue;
			if (relations.containsKey(entry.getValue())) {
				List<String> temp = relations.get(entry.getValue());
				temp.add(entry.getKey());
				relations.put(entry.getValue(), temp);
			} else {
				List<String> temp = new ArrayList<>();
				temp.add(entry.getKey());
				relations.put(entry.getValue(), temp);
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(relations));

		for (Map.Entry<String, List<String>> entry : relations.entrySet()) {
			relationHelper(entry.getKey(), relations);
		}

		System.out.println(mapper.writeValueAsString(result));

	}

	private static int relationHelper(String key, Map<String, List<String>> relations) {

		int count = 0;
		if (!relations.containsKey(key)) {
			result.put(key, 0);
			return 0;
		} else if (result.containsKey(key)) {
			count = result.get(key);
		} else {
			List<String> empl = relations.get(key);
			count = empl.size();

			for (String e: empl) 
				count += relationHelper(e, relations);
			result.put(key, count);
			
		}
		return count;
	}

}
