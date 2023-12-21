package finalproject;

import finalproject.system.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public abstract class PathFindingService {
	Tile source;
	Graph g;

	public PathFindingService(Tile start) {
    	this.source = start;
        generateGraph();
    }

	public abstract void generateGraph();

    private void initSingleSource(Tile s) {
    	for (Tile t : g.vertices) {
    		t.costEstimate = Double.POSITIVE_INFINITY;
    		t.predecessor = null;
    	}
    	s.costEstimate = 0;
    }

    private void relax(Tile u, Tile v, TilePriorityQ q) {
		double w = g.edgeWeight(u, v);

    	if (v.costEstimate > u.costEstimate + w) {
			v.costEstimate = u.costEstimate + w;
			v.predecessor = u;
    		q.updateKeys(v, u, v.costEstimate);

		}
    }

    //TODO level 4: Implement basic dijkstra's algorithm to find a path to the final unknown destination
    public ArrayList<Tile> findPath(Tile startNode) {
		initSingleSource(startNode);
		TilePriorityQ q = new TilePriorityQ(g.vertices);
		while (q.size > 0) {
			Tile u = q.removeMin();
			for (Tile v : g.getNeighbors(u)) {
				relax(u, v, q);
			}
		}

		ArrayList<Tile> path = new ArrayList<Tile>();
		Tile curr = null;
		for (Tile t : g.vertices) {
			if (t.isDestination) {
				curr = t;
				break;
			}
		}

		while (curr != startNode) {
			path.addFirst(curr);
			curr = curr.predecessor;
		}
		path.addFirst(startNode);
		return path;
    }

    //TODO level 5: Implement basic dijkstra's algorithm to path find to a known destination
    public ArrayList<Tile> findPath(Tile start, Tile end) {
		initSingleSource(start);
		TilePriorityQ q = new TilePriorityQ(g.vertices);
		while (q.size > 0) {
			Tile u = q.removeMin();
			for (Tile v : g.getNeighbors(u)) {
				relax(u, v, q);
			}
		}
		ArrayList<Tile> path = new ArrayList<Tile>();
		Tile curr = end;
		while (curr != start) {
			path.addFirst(curr);
			curr = curr.predecessor;
		}
		return path;
    }

    //TODO level 5: Implement basic dijkstra's algorithm to path find to the final destination passing through given waypoints
    public ArrayList<Tile> findPath(Tile start, LinkedList<Tile> waypoints) {
		if (waypoints.isEmpty()) {
			return findPath(start);
		}
		ArrayList<Tile> path = new ArrayList<Tile>();
		System.out.println(start);
		Tile tempStart = start;
		for (Tile t : waypoints) {
			System.out.println(tempStart);
			ArrayList<Tile> temp = findPath(tempStart, t);
			path.addAll(temp);
			System.out.println(tempStart);
			tempStart = t;
		}
		System.out.println(start);
		System.out.println(tempStart);
		return path;
	}
}

