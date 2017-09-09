package com.example.graph;

import java.util.ArrayList;
import java.util.List;

class Node {

	Node() {
	}

	public int id;
	public List<Node> adjecentList = new ArrayList<Node>();

	public Node(int i, List<Node> adjecentList) {
		this.id = i;
		this.adjecentList = adjecentList;
	}

}
