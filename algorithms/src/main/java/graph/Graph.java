package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graph<T> {

	int vertices;

	private Map<T, LinkedList<T>> adjacencyList;

	public Graph() {
		vertices = 0;
		adjacencyList = new HashMap<>();
	}

	public void addVertice(T t) {
		if (adjacencyList.containsKey(t))
			return;
		adjacencyList.put(t, new LinkedList<T>());
		vertices++;
	}

	public void addEdge(T s, T d) {
		if (adjacencyList.containsKey(s) && adjacencyList.containsKey(d)) {
			adjacencyList.get(s).add(d);
		}
	}

	public void printGraph() {
		Set<T> verticesSet = adjacencyList.keySet();
		for (T t : verticesSet) {
			System.out.println(t + " ");
		}

	}

	public void bfs(T s) {
		HashMap<T, Boolean> visited = new HashMap<>();
		LinkedList<T> queue = new LinkedList<>();
		visited.put(s, true);
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");
			List<T> listOfAdNodes = adjacencyList.get(s);
			for (T i : listOfAdNodes) {
				if (!visited.containsKey(i)) {
					visited.put(i, true);
					queue.add(i);
				}
			}
		}

	}
	
/*	public void dfs(T s) {
		HashMap<T, Boolean> visited = new HashMap<>();
		Stack<T> stack = new Stack<>();
		stack.push(s);
		
		while(!stack.isEmpty()) {
			s = stack.pop();
			System.out.println(s);
			if(!visited.containsKey(s)) {
				visited.put(s, true);
				List<T> list = adjacencyList.get(s);
				for(T t : list) {
					if(!visited.containsKey(t))
					stack.push(t);
				}
			}
		}
	}*/
	
	public void dfs(T s) {
		Map<T, Boolean> visited = new HashMap<>();
		dfsRecursive(s, visited);
	}
	
	public void dfsStack(T s) {
		Map<T, Boolean> visited = new HashMap<>();
		Stack<T> stack = new Stack<>();
		stack.push(s);
		while(!stack.isEmpty()) {
			T v = stack.pop();
			if(!visited.containsKey(v)) {
				visited.put(v, true);
				List<T> list = adjacencyList.get(v);
				for(T t : list) {
					stack.push(t);
				}
			}
		}
	}

	public void dfsRecursive(T s, Map<T, Boolean> visited) {
		visited.put(s, true);
		System.out.print(s + " ");
		List<T> list = adjacencyList.get(s);
		for(T t : list) {
			if(!visited.containsKey(t)) {
				dfsRecursive(t, visited);
			}
		}
	}
	
	public boolean isCycle(T s) {
		Map<T, String> colors = new HashMap<>();
		return isCyclic(s, colors);
	}
	
	public boolean isCyclic(T s, Map<T, String> colors) {
		// Mark the current node as grey or being processed.
		colors.put(s, "grey");
		// Get the adjacent vertices
		List<T> list = adjacencyList.get(s);
		for(T t : list) {
			if(colors.containsKey(t) && colors.get(t).equals("grey")) return true;
			if(!colors.containsKey(t)) {
				if(isCyclic(t, colors))
				return true;
			}
		}
		colors.put(s, "black");
		return false;
	}
	
	public void findPaths(T s, T d, Map<T, Boolean> visited, List<T> path) {
		path.add(s);
		visited.put(s, true);
		if(s == d) {
			System.out.println(path);
		}
		else {
			List<T> list = adjacencyList.get(s);
			for(T t : list) {
				if(!visited.containsKey(t)) {
					findPaths(t, d, visited, path);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph<String> g = new Graph<>();
		g.addVertice("A");
		g.addVertice("B");
		g.addVertice("C");
		g.addVertice("D");
		g.addVertice("E");
		g.addVertice("F");
		g.addVertice("G");

		g.addEdge("A", "B");
		g.addEdge("A", "G");
		g.addEdge("B", "F");
		g.addEdge("B", "C");
		g.addEdge("G", "F");
		g.addEdge("F", "E");
		g.addEdge("C", "E");
		g.addEdge("C", "D");
		g.addEdge("D", "A");
		
		
		System.out.println("BFS for the Graph");
		System.out.println("-------------------------");
		g.bfs("A");
		System.out.println("DFS for the Graph");
		System.out.println("-------------------------");
		g.dfs("A");
		System.out.println("DFS for the Graph using Stack ");
		System.out.println("-------------------------");
		g.dfs("A");
		
		System.out.println("Is Cyclic " + g.isCycle("A")); 
		
//		Map<Integer, Boolean> visited = new HashMap<>();
//		List<Integer> paths = new LinkedList<>();
//		g.findPaths(0, 3, visited, paths);
		
	}
}
