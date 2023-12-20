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
    		t.distanceCost = Integer.MAX_VALUE;
    		t.predecessor = null;
    	}
    	s.distanceCost = 0;
    }

    private void relax(Tile u, Tile v, double w) {
    	if (v.distanceCost > u.distanceCost + w) {
    		v.distanceCost = u.distanceCost + w;
    		v.predecessor = u;
    	}
    }

    private void dijkstra(ArrayList<Tile> vertices, Tile start) {
    	initSingleSource(start);
    	TilePriorityQ q = new TilePriorityQ(vertices);
    	while (q.size > 0) {
    		Tile u = q.removeMin();
    		for (Tile v : u.neighbors) {
    			relax(u, v, v.distanceCost);
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
    	return null;
    }

    //TODO level 5: Implement basic dijkstra's algorithm to path find to the final destination passing through given waypoints
    public ArrayList<Tile> findPath(Tile start, LinkedList<Tile> waypoints) {
    	return null;
    }

    private ArrayList<Tile> reconstructPath(HashMap<Tile, Tile> predecessor, Tile start, Tile end) {
        ArrayList<Tile> path = new ArrayList<>();
        Tile current = end;

        while (current != null && current != start) {
            path.add(current);
            current = predecessor.get(current);
        }

        if (current == start) {
            path.add(start);
            // Reverse the path to get the correct order
            ArrayList<Tile> reversedPath = new ArrayList<>();
            for (int i = path.size() - 1; i >= 0; i--) {
                reversedPath.add(path.get(i));
            }
            return reversedPath;
        } else {
            // No path found
            return new ArrayList<>();
        }
    }
        
}

