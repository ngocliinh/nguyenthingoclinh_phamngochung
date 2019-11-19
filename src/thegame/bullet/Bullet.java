package thegame.bullet;

import javafx.scene.canvas.GraphicsContext;
import thegame.GameEntities;
import thegame.enemy.Enemy;
import thegame.tile.GameTile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import thegame.tile.Tower;

import java.awt.*;

public class Bullet extends GameEntities {
    public double speed ;
    public double damage;
    public Bullet(double posX, double posY) {
        super(posX, posY);
    }
    public void action(GraphicsContext gc, Enemy enemy) {
        if (enemy.healthy + enemy.armor >= 0) {
            gc.strokeLine(enemy.getPosX()+32, enemy.getPosY()+32, posX, posY);
        }
    }

}
