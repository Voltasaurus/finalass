package finalproject.tiles;

import finalproject.system.Tile;
import finalproject.system.TileType;

public class MountainTile extends Tile {
    //TODO level 0: finish constructor
    public MountainTile() {
        this.type = TileType.Moutain;
        this.distanceCost = 100.0;
        this.timeCost = 100.0;
        this.damageCost = 100.0;
    }
}
