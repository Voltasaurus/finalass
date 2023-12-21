package finalproject;

import java.util.ArrayList;
import java.util.HashSet;

import finalproject.system.Tile;
import finalproject.system.TileType;
import finalproject.tiles.*;

public class Graph {
	// TODO level 2: Add fields that can help you implement this data type
    ArrayList<Tile> vertices;
    int graphSize;
    ArrayList<Edge>[] adjList;
    Edge[][] adjMatrix;


    // TODO level 2: initialize and assign all variables inside the constructor
	public Graph(ArrayList<Tile> vertices) {
        this.vertices = vertices;
        this.graphSize = vertices.size();
        adjList = new ArrayList[graphSize];
        adjMatrix = new Edge[graphSize][graphSize];
        for (int i = 0; i < graphSize; i++) {
            adjList[i] = new ArrayList<Edge>();
        }
	}
	
    // TODO level 2: add an edge to the graph
    public void addEdge(Tile origin, Tile destination, double weight) {
        Edge e = new Edge(origin, destination, weight);
        adjList[origin.nodeID].add(e);
        adjMatrix[origin.nodeID][destination.nodeID] = e;
    }
    
    // TODO level 2: return a list of all edges in the graph
	public ArrayList<Edge> getAllEdges() {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < graphSize; i++) {
            for (int j = 0; j < graphSize; j++) {
                if (adjMatrix[i][j] != null) {
                    edges.add(adjMatrix[i][j]);
                }
            }
        }
        return edges;
    }
  
	// TODO level 2: return list of tiles adjacent to t
	public ArrayList<Tile> getNeighbors(Tile t) {
        ArrayList<Tile> neighbors = new ArrayList<>();
        for (Edge e : adjList[t.nodeID]) {
            if (e.destination.isWalkable()) {
                neighbors.add(e.destination);
            }
        }
        return neighbors;
    }
	
	// TODO level 2: return total cost for the input path
	public double computePathCost(ArrayList<Tile> path) {
        double cost = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            Tile s = path.get(i);
            Tile d = path.get(i + 1);
            for (Edge edge : adjList[s.nodeID]) {
                if (edge.destination == d) {
                    cost += edge.weight;
                }
            }
        }
        return cost;
    }

    public double edgeWeight(Tile s, Tile d) {
        return adjMatrix[s.nodeID][d.nodeID].weight;
    }
   
    public static class Edge{
    	Tile origin;
    	Tile destination;
    	double weight;

        // TODO level 2: initialize appropriate fields
        public Edge(Tile s, Tile d, double cost){
            this.origin = s;
            this.destination = d;
            this.weight = cost;
        }
        
        // TODO level 2: getter function 1
        public Tile getStart(){
            return this.origin;
        }

        
        // TODO level 2: getter function 2
        public Tile getEnd() {
            return this.destination;
        }
        
    }
    
}