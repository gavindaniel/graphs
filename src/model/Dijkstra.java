package model;

public class Dijkstra {

	private Graph _graph;
	private String _result;
	
	// constructor 
	public Dijkstra(Graph g) {
		_graph = g;
		_result = "";
	}
	
	
	public String start(int starting_vertex) {
		printTable();
		search(_graph.getVertices()[starting_vertex - 1]);
		return _result;
	}
	
	private int[] initDistanceArray() {
		int d[] = new int[10];
		for (int i = 0; i < 10; i++) {
			d[i] = 9999;  // obvious default value (infinity)
		}
		return d;
	}
	
	// function for finding the minimum distance in the current row 
	private int findMinDistance(int[] distance, boolean[] processed) {
		int min_index = -1;
		int temp_min = 9999;
		for (int i = 0; i < 10; i++) {
			if (processed[i] == false && distance[i] < temp_min) {
				temp_min = distance[i];
				min_index = i;
			}
		}
		return min_index;
	}
	
	public void search(Vertex currentV) {
		
		int distance[] = initDistanceArray();	// distance from current vertex to every vertex in graph
		
		boolean processed[] = new boolean[10]; // array to keep track of processed vertices
		
		distance[currentV.getVertexNumber()-1] = 0;  // distance from source vertex to itself is always 0
		
		for (int i = 0; i < 9; i++) {
			// find the minimum index from the set of not yet processed vertices
			int min_index = findMinDistance(distance, processed);
			// set the vertex as processed now
			processed[min_index] = true;
			
			Vertex[] adjacentV = _graph.getVertices()[min_index].getAdjacentVertices();
			int[] weights = _graph.getVertices()[min_index].getWeights();
			
			// update the distance value of the adjacent vertices of the picked minimum vertex
			for (int j = 0; j < adjacentV.length; j++) {
				// get index number
				int adjacent_index = adjacentV[j].getVertexNumber()-1;
				// update distance[i] only if:
				// - it not yet processed
				// - the distance[min_index] + weights[adjacent_index] < distance[i]
				if (processed[adjacent_index] == false &&
						distance[min_index] + weights[j] < distance[adjacent_index] ) {
					distance[adjacent_index] = distance[min_index] + weights[j]; 
				}
			}
			printRow(distance, min_index);
		}
	}
	
	private void printTable() {
		_result += "\tV\t|";
		for (int i = 1; i <= 10; i++)
			_result += "\t" + i + "\t|";
		_result += "\n----------";
		for (int i = 1; i <= 10; i++)
			_result += "----------";
		_result += "\n";
	} 
	private void printRow(int[] distance, int vertexNum) {
		_result +="\t" + (vertexNum+1) + "\t|\t";
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] == 9999)
				_result += "~\t|\t";
			else 
				_result += distance[i] + "\t|\t";
		}
		_result += "\n";
	}
	
}
