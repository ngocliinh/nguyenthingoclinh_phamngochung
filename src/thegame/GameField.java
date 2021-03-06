package thegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import thegame.enemy.*;
import thegame.tile.Tower;

import java.util.ArrayList;

public class GameField {
    private int width;
    private int height;
    public int money = 10;
    public int healthy = 5;
    private GameStage gameStage;
    private ArrayList<Tower> towers = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();

    public GameField(){};

    public GameField(GameStage gameStage) {
        this.width = gameStage.getWidth();
        this.height = gameStage.getHeight();
        this.gameStage = gameStage;
    }

    public void drawMap(GraphicsContext gc) {
        for (int i = 0; i < gameStage.MAP_SPRITES.length; i++) {
            for (int j = 0; j < gameStage.MAP_SPRITES[i].length; j++) {
                gc.drawImage(new Image("file:image/towerDefense_tile" + gameStage.MAP_SPRITES[i][j] + ".png"), j * 64, i * 64);
            }
        }

        Font font = Font.font("Times New Roman", 25);
        gc.setFont(font);
        gc.fillText("Money: " + this.money, 50, 560);
        gc.fillText("Healthy: " + this.healthy, 500, 560);

        Font font1 = Font.font("Times New Roman", 20);
        gc.setFont(font1);
        gc.fillText("5$", 730, 80);
        gc.fillText("10$",795, 80);
        gc.fillText("15$", 860, 80);
        gc.strokeRect(0,0, 704, 512);
        gc.strokeRect(704, 0, 64, 64);
        gc.strokeRect(768, 0, 64, 64);
        gc.strokeRect(832,0, 64, 64);

    }
    // sinh ra quân địch chuẩn bị đi vào
    public void spawnEnemy(ArrayList<Enemy> enemies) {
        for (int i = 0; i < 5; i++) {
            enemies.add(new NormalEnemy(96 , 448 +i*50, 1));
        }
        for(int i=5; i<8;i++) {
            enemies.add(new TankerEnemy( 96, 448 + i*50, 1));
        }
        for(int i = 8; i< 10; i++) {
            enemies.add(new SmallerEnemy(96, 448 + i*70, 1));
        }
        for(int i=10; i<12;i++) {
            enemies.add(new BossEnemy(96, 448 + i*70, 1));
        }
    }
    // quân địch biến mất khi đến đích
    public void removeEnemy(ArrayList<Enemy> enemies) {
        for(int i=0; i<enemies.size(); i++) {
            if(enemies.get(i).getPosX() > 10*Config.SIZE) {
                enemies.remove(i);
                healthy --;
            }
        }
    }

    public void addTower(Tower tower) {
        towers.add(tower);
    }
    public boolean checkGameOver() {
       if (healthy <= 0) return true;
       return false;
    }
}
