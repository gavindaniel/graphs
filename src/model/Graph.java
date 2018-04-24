package model;

import java.util.Observable;

public class Graph extends Observable {

	// static final variable(s)
	public static final int size = 10;	// # of MAX vertices 
	// variable(s)
	private Vertex root;			// root vertex of the graph
	private int numVertices;		// number of vetices in the graph (or current size of graph)
	
	// constructor 
	public Graph() {
		// TODO: add any construction code
	}
	
	// getters 
	public int getSize() {	return size;		}
	public Vertex getRoot() {	return root;		}
	public int getNumVertices() {	return numVertices;		}
	// setters
	public void setRoot(Vertex r) {		root = r;	}
	public void setNumVertices(int n) {	numVertices = n;		}
}
