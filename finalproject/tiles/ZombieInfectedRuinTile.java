package finalproject.tiles;

import finalproject.system.Tile;
import finalproject.system.TileType;

public class ZombieInfectedRuinTile extends Tile {
    //TODO level 0: finish constructor
    public ZombieInfectedRuinTile() {
        this.type = TileType.ZombieInfectedRuin;
        this.distanceCost = 1.0;
        this.timeCost = 3.0;
        this.damageCost = 5.0;
    }
}
