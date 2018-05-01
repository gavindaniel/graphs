package model;

public class DFS {

	private Graph _graph;
	private String _result;
	private boolean[] _visited;
	
	// constructor 
	public DFS(Graph g) {
		_graph = g;
		_result = "";
		_visited = new boolean[10]; //size
	}
	
	public String start(int starting_vertex) {
		_result = search(_graph.getVertices()[starting_vertex - 1], _visited, _result);
		return _result;
	}
	
	public String search(Vertex currentV, boolean[] visited, String result) {
		String out = "";
		// mark the current node as visited
		visited[currentV.getVertexNumber()-1] = true;
		System.out.print(currentV.getVertexNumber() + " ");
		result += currentV.getVertexNumber() + " ";
		
		boolean done = true;
		for (int j = 0; j < visited.length; j++) {
			if (visited[j] == false)
				done = false;
		}
		if (!done) {
			Vertex[] adjacentV = currentV.getAdjacentVertices();
			for (int i = 0; i < adjacentV.length; i++) {
					if (!visited[adjacentV[i].getVertexNumber()-1]) // the vertex has not been visited
						out = search(adjacentV[i], visited, result);
			}
		}
		else if (done)
			out = result;
		return out;
	}
}
