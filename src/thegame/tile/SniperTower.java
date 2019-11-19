package thegame.tile;

import javafx.scene.image.Image;
import thegame.Config;

public class SniperTower extends Tower {
    public SniperTower() {}
    public SniperTower(double posX, double posY) {
        super(posX, posY);
        this.imgT = new Image("file:image/towerDefense_tile206.png");
        this.gunImageT = new Image("file:image/towerDefense_tile181.png");
        this.range = Config.SNIPER_TOWER_RANGE;
    }
}
