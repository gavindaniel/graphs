package model;

import java.util.Observable;

public class Graph extends Observable {

	// static final variable(s)
	public static final int size = 10;	// # of MAX vertices 
	// variable(s)
	private Vertex root;
	
	// constructor 
	public Graph() {
		// TODO: add any construction code
	}
	
	public int getSize() {	return size;		}
}
