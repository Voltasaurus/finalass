package finalproject;

import finalproject.system.Tile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class GraphTraversal {

	//TODO level 1: implement BFS traversal starting from s
	public static ArrayList<Tile> BFS(Tile s) {
		LinkedList<Tile> queue = new LinkedList<>();
		HashSet<Tile> visited = new HashSet<>();
		ArrayList<Tile> path = new ArrayList<>();
		queue.add(s);
		visited.add(s);
		while (!queue.isEmpty()) {
			Tile current = queue.poll();
			path.add(current);
			for (Tile t : current.neighbors) {
				if (!visited.contains(t) && t.isWalkable()) {
					visited.add(t);
					queue.add(t);
				}
			}
		}
		return path;
	}


	//TODO level 1: implement DFS traversal starting from s
	public static ArrayList<Tile> DFS(Tile s) {
		LinkedList<Tile> stack = new LinkedList<>();
		HashSet<Tile> visited = new HashSet<>();
		ArrayList<Tile> path = new ArrayList<>();
		stack.push(s);
		visited.add(s);
		while (!stack.isEmpty()) {
			Tile current = stack.pop();
			path.add(current);
			for (Tile t : current.neighbors) {
				if (!visited.contains(t) && t.isWalkable()) {
					visited.add(t);
					stack.push(t);
				}
			}
		}
		return path;
	}
}