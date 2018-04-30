package model;

import java.util.Observable;

public class Graph extends Observable {

	// static final variable(s)
	public static final int size = 10;	// # of MAX vertices 
	// variable(s)
	private Vertex root;			// root vertex of the graph
	private int numVertices;		// number of vetices in the graph (or current size of graph)
	private Vertex[] vertices;	// vertices in the graph
	// constructor 
	public Graph() {
		// TODO: add any construction code
		root = new Vertex();
		numVertices = 0;
		vertices = new Vertex[0];
	}
	
	// getters 
	public int getSize() {	return size;		}
	public Vertex getRoot() {	return root;		}
	public int getNumVertices() {	return numVertices;		}
	// setters
	public void setRoot(Vertex r) {		root = r;	}
	public void setNumVertices(int n) {	numVertices = n;		}
	// array functions
	public void add(Vertex v) {
		Vertex[] tempV = vertices;
		vertices = new Vertex[tempV.length + 1];
		for (int i = 0; i < tempV.length; i++) {
			vertices[i] = tempV[i];
		}
		vertices[tempV.length] = v;
		this.setNumVertices(vertices.length);
	}
	
	// search functions
	
	// breadth first search
	public String BFS(int startV) {
		String result = "";
		boolean[] visited = new boolean[size];
		Vertex[] stack = new Vertex[0];
		result = search_BFS(vertices[startV-1], stack, visited, result);
		return result;
	}
	
	public String search_BFS(Vertex v, Vertex[] stack, boolean[] visited, String result) {
		String out = "";
		visited[v.getVertexNumber()-1] = true;
		System.out.print(v.getVertexNumber() + " ");
		result += v.getVertexNumber() + " ";
		
		Vertex[] adjV = v.getAdjacentVertices();
		Vertex[] temp = stack;
//		stack = new Vertex[stack.length + adjV.length];
//		for (int i = 0; i < temp.length; i++) {
//			stack[i] = temp[i];
//		}
		for (int i = 0; i < adjV.length; i++) {
//			Vertex[] temp = stack;
			boolean flag = false;
			for (int j = 0; j < temp.length; j++) {
				if (adjV[i].getVertexNumber() == temp[j].getVertexNumber())
					flag = true;
			}
			if (!flag) {
				temp = stack;
				stack = new Vertex[stack.length + 1];
				for (int k = 0; k < temp.length; k++) {
					stack[k] = temp[k];
				}
				stack[temp.length] = adjV[i];
			}
		}
		boolean done = true;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false) {
				done = false;
			}
		}
		
		if (!done && stack.length > 0)
			for (int i = 0; i < stack.length; i++) {
				if (!visited[stack[i].getVertexNumber()-1])
					out = search_BFS(stack[i], stack, visited, result);
			}
		else if (done)
			out = result;
		
		return out;
	}
	
	
	// depth first search
	public String DFS(int startV) {
		String result = "";
		boolean[] visited = new boolean[size];
		
		result = search_DFS(vertices[startV-1], visited, result);
		return result;
	}
	
	public String search_DFS(Vertex v, boolean[] visited, String result) {
		String out = "";
		// mark the current node as visited
		visited[v.getVertexNumber()-1] = true;
		System.out.print(v.getVertexNumber() + " ");
		result += v.getVertexNumber() + " ";
		
		boolean done = true;
		for (int j = 0; j < visited.length; j++) {
			if (visited[j] == false)
				done = false;
		}
		if (!done) {
			Vertex[] adjacentV = v.getAdjacentVertices();
			for (int i = 0; i < adjacentV.length; i++) {
					if (!visited[adjacentV[i].getVertexNumber()-1]) // the vertex has not been visited
						out = search_DFS(adjacentV[i], visited, result);
			}
		}
		else if (done)
			out = result;
		return out;
	}
}
