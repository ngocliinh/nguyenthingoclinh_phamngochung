package thegame.tile;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import thegame.Config;

public class NormalTower extends Tower {

    public NormalTower(){}

    public NormalTower(double posX, double posY) {
        super(posX, posY);
        this.imgT = new Image("file:image/towerDefense_tile249.png");
        this.gunImageT = new Image("file:image/towerDefense_tile181.png");
        this.range = Config.NORMAL_TOWER_RANGE;
    }

}
