package finalproject.tiles;

import finalproject.system.Tile;
import finalproject.system.TileType;

public class PlainTile extends Tile {
    //TODO level 0: finish constructor
    public PlainTile() {
        this.type = TileType.Plain;
        this.distanceCost = 3.0;
        this.timeCost = 1.0;
        this.damageCost = 0.0;
    }
}
