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
//	public Edge[] getEdges() {		return edges;			}
	// setters
	public void setVertexNumber(int n) {		this.vertexNumber = n;	}
	public void setAdjacentVertices(Vertex[] v) {  this.adjacent = v; }
//	public void setEdges(Edge[] e) {			this.edges = e;			}
	
	// edge array functions
	public void addAdjacentVertex(Vertex v) {
		// check if the vertex is already in the array
		if (checkForAdjacentVertex(v)) { // if it does already exist in the array
			System.out.println("Error!! This vertex is already in the adjacent array!!");
		}
		else { // the vertex does not already exist so add it
//			 check if this is the first edge in the array
			if (adjacent.length == 0) {
				adjacent = new Vertex[] {v};
				weights = new int[] {1};
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
				weights[tempW.length] = 1; 	// FIXME: 
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
	
//	public void addEdge(Edge e) {
//		// check if the edge already exists
//		if (checkForEdge(e)) {
//			// FIXME: Remove for final submission
//			System.out.println("Error!!! This edge already exists!!!");
//		}
//		else { // the edge does not already exist, so add it
//			// check if this is the first edge in the array
//			if (edges.length == 0) {
//				edges = new Edge[] {e};
//			}
//			else { // the array is not empty
//				Edge[] temp = edges;
//				edges = new Edge[temp.length + 1]; // creates a new array with the old size + 1
//				for (int i = 0; i < temp.length; i++) {
//					edges[i] = temp[i];
//				}
//				edges[temp.length] = e; // add the new edge at the very end 
//			}
//		}
//	}
	
//	public boolean checkForEdge(Edge e) {
//		// loop through the array of edges
//		for (int i = 0; i < edges.length; i++) {
//			// check if the edge array index origin is equal to the edge 'e' origin
//			if (edges[i].getOrigin().getVertexNumber() == e.getOrigin().getVertexNumber())
//				// check if the edge array index destination is equal to the edge 'e' destination
//				if (edges[i].getDestination().getVertexNumber() == e.getDestination().getVertexNumber())
//					return true;
//			// check if the edge array index origin is equal to the edge 'e' destination
//			else if (edges[i].getOrigin().getVertexNumber() == e.getDestination().getVertexNumber())
//				// check if the edge array index destination is equal to the edge 'e' destination
//				if (edges[i].getDestination().getVertexNumber() == e.getOrigin().getVertexNumber())
//					return true;
//			// NOT NEEDED
////			// check if the edge array index destination is equal to the edge 'e' origin
////			else if (edges[i].getDestination().getVertexNumber() == e.getOrigin().getVertexNumber())
////				// check if the edge array index origin is equal to the edge 'e' destination
////				if (edges[i].getOrigin().getVertexNumber() == e.getDestination().getVertexNumber())
////					return true; 
////			// check if the edge array index destination is equal to the edge 'e' destination
////			else if (edges[i].getDestination().getVertexNumber() == e.getDestination().getVertexNumber())
////				// check if the edge array index origin is equal to the edge 'e' origin
////				if (edges[i].getOrigin().getVertexNumber() == e.getDestination().getVertexNumber())
////					return true; 
//		}
//		
//		// the edge was not found in the array
//		return false;
//	}
	
}
