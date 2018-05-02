package model;

public class Vertex {

	// variable(s)
	private int vertexNumber;	// # vertex in the graph (name of vertex)
	private Vertex[] adjacent;	// adjacent vertices
	private int[] weights;
//	private Edge[] edges;		// edge(s) that belongs to the vertex
	
	// blank constructor 
	public Vertex() {
		vertexNumber = -9999;	// obvious init value 
		adjacent = new Vertex[0];
		weights = new int[0];
	}
	// pre-filled constructor
	public Vertex(int n) {
		vertexNumber = n;
		adjacent = new Vertex[0];
//		edges = new Edge[0];		// init the array with 0 elements?
	}
	
	// getters
	public int getVertexNumber() {	return vertexNumber;		}
	public Vertex[] getAdjacentVertices() { return adjacent;	}
	public int[] getWeights() {		return weights;			}
	// setters
	public void setVertexNumber(int n) {		this.vertexNumber = n;	}
	public void setAdjacentVertices(Vertex[] v) {  this.adjacent = v; }
//	public void setEdges(Edge[] e) {			this.edges = e;			}
	
	// edge array functions
	public void addAdjacentVertex(Vertex v, int weight) {
		// check if the vertex is already in the array
		if (checkForAdjacentVertex(v)) { // if it does already exist in the array
			System.out.println("Error!! This vertex is already in the adjacent array!!");
		}
		else { // the vertex does not already exist so add it
//			 check if this is the first edge in the array
			if (adjacent.length == 0) {
				adjacent = new Vertex[] {v};
				weights = new int[] {weight};
			}
			else { // the array is not empty
				Vertex[] temp = adjacent;
				int[] tempW = weights;
				adjacent = new Vertex[temp.length + 1]; // creates a new array with the old size + 1
				weights = new int[tempW.length + 1];
				for (int i = 0; i < temp.length; i++) {
					adjacent[i] = temp[i];
					weights[i] = tempW[i];
				}
				adjacent[temp.length] = v; // add the new vertex at the very end 
				weights[tempW.length] = weight; 	// add the new weight at the very end
			}
		}
	}
	
	public boolean checkForAdjacentVertex(Vertex v) {
		for (int i = 0; i < adjacent.length; i++) {
			if (adjacent[i].getVertexNumber() == v.getVertexNumber())
				return true;
		}
		return false;
	}
	
}
