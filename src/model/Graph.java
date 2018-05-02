package model;

import java.util.Observable;

public class Graph extends Observable {

	// static final variable(s)
	public static final int size = 10;	// # of MAX vertices 
	// variable(s)
	private Vertex root;			// root vertex of the graph
	private int numVertices;		// number of vertices in the graph (or current size of graph)
	private Vertex[] vertices;	// vertices in the graph
	
	// constructor 
	public Graph() {
		root = new Vertex();
		numVertices = 0;
		vertices = new Vertex[0];
	}
	
	// getters 
	public int getSize() {	return size;		}
	public Vertex getRoot() {	return root;		}
	public int getNumVertices() {	return numVertices;		}
	public Vertex[] getVertices() {	return vertices;	}
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
	
	
	public static Graph graph1() {
		Graph g = new Graph();
		// init vertices 
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		Vertex v7 = new Vertex(7);
		Vertex v8 = new Vertex(8);
		Vertex v9 = new Vertex(9);
		Vertex v10 = new Vertex(10);
		// init edges 
//		Edge e1 = new Edge(v1, v2, 1);
//		v1.addEdge(e1);
		
		// vertex 1 adjacent
		v1.addAdjacentVertex(v2, 1);
		v1.addAdjacentVertex(v3, 2);
		v1.addAdjacentVertex(v4, 4);
		// vertex 2 adjacent
		v2.addAdjacentVertex(v1, 1);
		v2.addAdjacentVertex(v3, -2);
		v2.addAdjacentVertex(v4, 3);
		// vertex 3 adjacent
		v3.addAdjacentVertex(v1, 2);
		v3.addAdjacentVertex(v2, -2);
		v3.addAdjacentVertex(v4, 2);
//		v3.addAdjacentVertex(v5);
		// vertex 4 adjacent
		v4.addAdjacentVertex(v1, 4);
		v4.addAdjacentVertex(v2, 3);
		v4.addAdjacentVertex(v3, 2);
		v4.addAdjacentVertex(v6, 2);
		// vertex 5 adjacent
		v5.addAdjacentVertex(v6, -3);
		v5.addAdjacentVertex(v7, -2);
		v5.addAdjacentVertex(v8, 1);
//		v5.addAdjacentVertex(v3);
		// vertex 6 adjacent
		v6.addAdjacentVertex(v4, 2);
		v6.addAdjacentVertex(v5, -3);
		v6.addAdjacentVertex(v7, 1);
		// vertex 7 adjacent
		v7.addAdjacentVertex(v5, -2);
		v7.addAdjacentVertex(v6, 1);
		v7.addAdjacentVertex(v8, 4);
		// vertex 8 adjacent
		v8.addAdjacentVertex(v5, 1);
		v8.addAdjacentVertex(v7, 4);
		v8.addAdjacentVertex(v10, 2);
		// vertex 9 adjacent
		v9.addAdjacentVertex(v8, 1);
		v9.addAdjacentVertex(v10, 3);
		// vertex 10 adjacent
		v10.addAdjacentVertex(v8, 2);
		v10.addAdjacentVertex(v9, 3);
		
		// add vertices to graph
		g.add(v1);
		g.add(v2);
		g.add(v3);
		g.add(v4);
		g.add(v5);
		g.add(v6);
		g.add(v7);
		g.add(v8);
		g.add(v9);
		g.add(v10);
		// set root of graph
		g.setRoot(v1);
		// add vertices to graph
		
		
		return g;
		
	}
}
