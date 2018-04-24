package model;

public class Edge {

	private Vertex origin;		// origin vertex of the edge
	private Vertex destination;	// destination vertex of the edge
	private int weight;			// weight of the edge 
	
	// empty constructor
	public Edge() {
		origin = new Vertex();			// empty vertex
		destination = new Vertex();		// empty vertex
		weight = -9999;					// obvious value to represent an initialized edge
	}
	// pre-filled constructor
	public Edge(Vertex o, Vertex d, int w) {
		origin = o;
		destination = d;
		weight = w;
	}
	
	// getters
	public Vertex getOrigin() {		return origin;	}
	public Vertex getDestination() {		return destination;	}
	public int getWeight() {		return weight;	}
	// setters
	public void setOrigin(Vertex o) {	this.origin = o;		}
	public void setDestination(Vertex d) {	this.destination = d;	}
	public void setWeight(int w) {	this.weight = w;		}
}
