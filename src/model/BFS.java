package model;

public class BFS {

	private Graph _graph;
	private String _result;
	private boolean[] _visited;
	private Vertex[] _stack;
	
	// constructor 
	public BFS(Graph g) {
		_graph = g;
		_result = "";
		_visited = new boolean[10]; //size
		_stack = new Vertex[0];
	}
	
	public String start(int starting_vertex) {
		_result = search(_graph.getVertices()[starting_vertex - 1], _stack, _visited, _result);
		return _result;
	}
	
	public String search(Vertex currentV, Vertex[] stack, boolean[] visited, String result) {
		String out = "";
		visited[currentV.getVertexNumber()-1] = true;
		System.out.print(currentV.getVertexNumber() + " ");
		result += currentV.getVertexNumber() + " ";
		
		Vertex[] adjV = currentV.getAdjacentVertices();
		Vertex[] temp = stack;

		for (int i = 0; i < adjV.length; i++) {
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
					out = search(stack[i], stack, visited, result);
			}
		else if (done)
			out = result;
		
		return out;
	}
}
