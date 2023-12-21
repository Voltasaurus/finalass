package finalproject.tiles;

import finalproject.system.Tile;
import finalproject.system.TileType;

public class MetroTile extends Tile {
	public double metroTimeCost = 100;
	public double metroDistanceCost = 100;
	public double metroCommuteFactor = 0.2;
	
    //TODO level 0: finish constructor
    public MetroTile() {
        this.type = TileType.Metro;
        this.distanceCost = 1.0;
        this.timeCost = 1.0;
        this.damageCost = 2.0;
    }
    
    // TODO level 7: updates the distance and time cost differently between metro tiles
    public void fixMetro(Tile node) {
        double distance = Math.abs(this.xCoord - node.xCoord) + Math.abs(this.yCoord - node.yCoord);
        this.metroTimeCost = distance * metroCommuteFactor;
        this.metroDistanceCost = distance / metroCommuteFactor;
    }
}
