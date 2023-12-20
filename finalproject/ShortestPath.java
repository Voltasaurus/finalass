package finalproject;


import finalproject.system.Tile;

import java.util.ArrayList;

public class ShortestPath extends PathFindingService {
    //TODO level 4: find distance prioritized path
    public ShortestPath(Tile start) {
        super(start);
        generateGraph();
        findPath(start);
    }

	@Override
	public void generateGraph() {
		// TODO Auto-generated method stub
        int id = 0;
        ArrayList<Tile> vertices = GraphTraversal.DFS(source);
        for (Tile t : vertices) {
            t.nodeID = id;
            id++;
        }
        g = new Graph(vertices);
        for (Tile t : vertices) {
            ArrayList<Tile> neighbors = t.neighbors;
            for (Tile n : neighbors) {
                g.addEdge(t, n, n.distanceCost);
            }
        }
	}
}