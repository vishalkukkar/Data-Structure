package com.example.java8;

import com.example.tree.TreeNode;

public class JavaBasics {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		/*Class<?> test = Class.forName("com.example.tree.TreeNode");
		Class<?> allClasses = com.example.array.matrix.MutiplyMatrix.class;
		Class<?> test2 = TreeNode.class;
		
		for(Method m:test2.getMethods()){
			System.out.println(m.getName());
		}*/
		
		//create instance
		TreeNode t = TreeNode.class.newInstance();
		Thread t1 = new Thread();
		t1.start();
		
		
		

	}

}
