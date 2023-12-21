package finalproject;

import finalproject.system.Tile;
import finalproject.system.TileType;
import finalproject.tiles.MetroTile;

import java.util.ArrayList;

public class FastestPath extends PathFindingService {
    //TODO level 6: find time prioritized path
    public FastestPath(Tile start) {
        super(start);
        generateGraph();
    }

	@Override
	public void generateGraph() {
		// TODO Auto-generated method stub
		int id = 0;
        ArrayList<Tile> vertices = GraphTraversal.BFS(source);
        for (Tile t : vertices) {
            t.nodeID = id;
            id++;
        }
        g = new Graph(vertices);
        for (Tile t : vertices) {
            ArrayList<Tile> neighbors = t.neighbors;
            for (Tile n : neighbors) {
                if (t.type == TileType.Metro && n.type == TileType.Metro) {
                    MetroTile metro = (MetroTile) t;
                    MetroTile metro2 = (MetroTile) n;
                    metro2.fixMetro(metro2);
                    g.addEdge(t, n, metro.metroTimeCost);
                } else if (t.isWalkable() && n.isWalkable()) {
                    g.addEdge(t, n, n.timeCost);
                }
            }
        }
	}

}
