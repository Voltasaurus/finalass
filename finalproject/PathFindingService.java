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
    		t.costEstimate = Double.MAX_VALUE;
    		t.predecessor = null;
    	}
    	s.costEstimate = 0;
    }

    private void relax(Tile u, Tile v, double w) {
    	if (v.costEstimate > u.costEstimate + w) {
    		v.costEstimate = u.costEstimate + w;
    		v.predecessor = u;
    	}
    }

    private void dijkstra(ArrayList<Tile> vertices, Tile start) {
    	initSingleSource(start);
    	TilePriorityQ q = new TilePriorityQ(vertices);
    	while (q.size > 0) {
    		Tile u = q.removeMin();
    		for (Tile v : u.neighbors) {
    			relax(u, v, v.costEstimate);
    		}
    	}
    }
    
    //TODO level 4: Implement basic dijkstra's algorithm to find a path to the final unknown destination
    public ArrayList<Tile> findPath(Tile startNode) {
        dijkstra(g.vertices, startNode);
        return g.vertices;
    }
    
    //TODO level 5: Implement basic dijkstra's algorithm to path find to a known destination
    public ArrayList<Tile> findPath(Tile start, Tile end) {
        ArrayList<Tile> path = new ArrayList<Tile>();
		dijkstra(g.vertices, start);
		Tile current = end;
		while (current != start) {
			path.add(current);
			current = current.predecessor;
		}
		return path;
    }

    //TODO level 5: Implement basic dijkstra's algorithm to path find to the final destination passing through given waypoints
    public ArrayList<Tile> findPath(Tile start, LinkedList<Tile> waypoints) {
    			ArrayList<Tile> path = new ArrayList<Tile>();
		Tile current = start;
		for (Tile t : waypoints) {
			ArrayList<Tile> subPath = findPath(current, t);
			path.addAll(subPath);
			current = t;
		}
		ArrayList<Tile> subPath = findPath(current);
		path.addAll(subPath);
		return path;
    }

}

