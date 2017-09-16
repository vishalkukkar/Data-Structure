package com.example.graph;

class GraphNode {

	GraphNode() {
	}

	public int value;
	public Boolean isVisited;
	public GraphNode[] adjecentList;

	public GraphNode(int i, GraphNode[] adjecentList) {
		this.value = i;
		this.adjecentList = adjecentList;
		this.isVisited = false;
	}

	public GraphNode(int i) {
		this.value = i;
	}

}
