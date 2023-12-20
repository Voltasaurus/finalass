package finalproject.tiles;

import finalproject.system.Tile;
import finalproject.system.TileType;

public class DesertTile extends Tile {
    //TODO level 0: finish constructor
    public DesertTile() {
        this.type = TileType.Desert;
        this.distanceCost = 2.0;
        this.timeCost = 6.0;
        this.damageCost = 3.0;
    }
}
