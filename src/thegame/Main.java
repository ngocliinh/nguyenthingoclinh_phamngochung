package thegame;

import com.sun.javafx.geom.BaseBounds;
import com.sun.media.jfxmedia.MediaPlayer;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import thegame.bullet.Bullet;
import thegame.bullet.MachineGunBullet;
import thegame.bullet.NormalBullet;
import thegame.bullet.SniperBullet;
import thegame.enemy.*;
import thegame.tile.MachineGunTower;
import thegame.tile.NormalTower;
import thegame.tile.SniperTower;
import thegame.tile.Tower;
import java.util.ArrayList;

public class Main extends Application {
    public int SIZE_ENEMYS = 15;
    public GameField gameField = new GameField();
    public GameStage gameStage;
    public double mouseX = -1, mouseY = -1;
    public int kind = 0;
    public int type = 1;
    public boolean PAUSE = false;

    public int inp_enemyNormal = 0;


    public ArrayList<Enemy> enemys = new ArrayList<>();
    ArrayList<Tower> towers = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();

    Image start1 = new Image("file:image/start1.png");

    Image imgT = new Image("file:image/towerDefense_tile181.png");
    Image imgT1 = new Image("file:image/towerDefense_tile249.png");
    Image imgT2 = new Image("file:image/towerDefense_tile206.png");
    Image imgT3 = new Image("file:image/towerDefense_tile250.png");
    Image imgPause = new Image("file:image/towerDefense_tile134.png");

    MediaPlayer mediaPlayer;

    @Override
    public void start(Stage theStage) throws Exception {
        theStage.setTitle("TowerDefense");

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(896, 600);

        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(start1, 0, 0);
    //sinh ra quân địch
        gameField.spawnEnemy(enemys);

        new AnimationTimer() {

            @Override
            public void handle(long l) {
                if (type == 1) {
                    canvas.setOnMouseClicked(
                            new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    if (mouseEvent.getX() > 319 && mouseEvent.getX() < 563
                                            && mouseEvent.getY() > 463 && mouseEvent.getY() < 532) {
                                        type = 2;
                                    }

                                }
                            }
                    );
                }
                if (type == 2) {
                    gc.clearRect(0, 0, 896, 600);

                    canvas.setOnMouseMoved(
                            new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    if (inp_enemyNormal == 1 && mouseEvent.getX() <= 672 && mouseEvent.getY() <= 480) {
                                        mouseX = mouseEvent.getX();
                                        mouseY = mouseEvent.getY();
                                    } else {
                                        mouseX = -1;
                                        mouseY = -1;
                                    }
                                }
                            }
                    );
                    // xét click chuột
                    canvas.setOnMouseClicked(
                            new EventHandler<MouseEvent>() {
                                public void handle(MouseEvent e) {
                                    if ((e.getX() > 704 && e.getX() < 768) && e.getY() < 64 && gameField.money >= 5) {
                                        inp_enemyNormal = 1;
                                        kind = 1;
                                    } if (e.getX() > 768 && e.getX() < 832 && e.getY() < 64 && gameField.money >= 10) {
                                        inp_enemyNormal = 1;
                                        kind = 2;
                                    } if (e.getX() > 832 && e.getY() < 64 && gameField.money >= 15) {
                                        inp_enemyNormal = 1;
                                        kind = 3;
                                    }  if (e.getX() <= 704 && inp_enemyNormal > 0) {
                                        if (kind == 1) {
                                            inp_enemyNormal = 0;
                                            towers.add(new NormalTower(e.getX() - 32, e.getY() - 32));
                                            gameField.money -= 5;
                                            if (towers.get(towers.size() - 1).checkArea() == false)
                                                towers.remove(towers.size() - 1);
                                        } else if (kind == 2) {
                                            inp_enemyNormal = 0;
                                            towers.add(new SniperTower(e.getX() - 32, e.getY() - 32));
                                            gameField.money -= 10;
                                            if (towers.get(towers.size() - 1).checkArea() == false)
                                                towers.remove(towers.size() - 1);
                                        } else if (kind == 3) {
                                            inp_enemyNormal = 0;
                                            towers.add(new MachineGunTower(e.getX() - 32, e.getY() - 32));
                                            gameField.money -= 15;
                                            if (towers.get(towers.size() - 1).checkArea() == false)
                                                towers.remove(towers.size() - 1);
                                        }
                                    }  if(e.getX() <64 && e.getY() < 64) {
                                        PAUSE = true;
                                    }
                                    // dừng màn hình
                                    if(e.getX() >= 20 ) PAUSE = false;
                                }
                            });
                    gameField.drawMap(gc);
                    if (kind == 1 && mouseX != -1) {
                        gc.drawImage(imgT, mouseX - 32, mouseY - 32);
                        gc.drawImage(imgT1, mouseX - 32, mouseY - 32);
                    } else if (kind == 2 && mouseX != -1) {
                        gc.drawImage(imgT, mouseX - 32, mouseY - 32);
                        gc.drawImage(imgT2, mouseX - 32, mouseY - 32);
                    } else if (mouseX != -1) {
                        gc.drawImage(imgT, mouseX - 32, mouseY - 32);
                        gc.drawImage(imgT3, mouseX - 32, mouseY - 32);
                    }
                    gc.drawImage(imgPause, 0, 0);

                    //gameField.removeEnemy(enemys);

                    if (!enemys.isEmpty()) {

                        for (int i = 0; i < enemys.size(); i++) {
                            if(PAUSE == false)
                                enemys.get(i).setPos();
                            if (enemys.get(i).getPosY() <= 448)
                                enemys.get(i).move(gc);
                        }
                        if(PAUSE == false) {
                            //duyệt tháp và quân địch
                            for (int i = 0; i < towers.size(); i++) {
                                if (!enemys.isEmpty()) {
                                    for (int j = 0; j < enemys.size(); j++) {
                                        if (!enemys.isEmpty() &&
                                                towers.get(i).distance(enemys.get(j)) < towers.get(i).range &&
                                                enemys.get(j).getPosY() <= 448) {
                                            //kiểm tra loại tháp
                                            if (towers.get(i) instanceof NormalTower) {
                                                NormalBullet normalBullet = new NormalBullet(towers.get(i).getPosX() + 32, towers.get(i).getPosY() + 32);
                                                normalBullet.action(gc, enemys.get(j));
                                                enemys.get(j).setHealthy(normalBullet);
                                                if (enemys.get(j).getHealthy() < 0 && !enemys.isEmpty()) {
                                                    gameField.money += enemys.get(j).reward;
                                                    enemys.remove(j);
                                                }
                                                break;

                                            }
                                            if (towers.get(i) instanceof SniperTower) {
                                                SniperBullet sniperBullet = new SniperBullet(towers.get(i).getPosX() + 32, towers.get(i).getPosY() + 32);
                                                sniperBullet.action(gc, enemys.get(j));
                                                enemys.get(j).setHealthy(sniperBullet);
                                                if (enemys.get(j).getHealthy() < 0 && !enemys.isEmpty()) {
                                                    gameField.money += enemys.get(j).reward;
                                                    enemys.remove(j);
                                                }
                                                break;

                                            }

                                            if (towers.get(i) instanceof MachineGunTower) {
                                                MachineGunBullet machineGunBullet = new MachineGunBullet(towers.get(i).getPosX() + 32, towers.get(i).getPosY() + 32);
                                                machineGunBullet.action(gc, enemys.get(j));
                                                enemys.get(j).setHealthy(machineGunBullet);
                                                if (enemys.get(j).getHealthy() < 0 && !enemys.isEmpty()) {
                                                    gameField.money += enemys.get(j).reward;
                                                    enemys.remove(j);
                                                }
                                                break;

                                            }
                                        }


                                    }
                                }

                                if (enemys.isEmpty()) {
                                    type = 4;
                                    break;
                                }
                            }
                        }
                           if(!enemys.isEmpty()) gameField.removeEnemy(enemys);



                        }
                    for (int i = 0; i < towers.size(); i++) {

                        towers.get(i).drawTower(gc, towers.get(i).getPosX(), towers.get(i).getPosY());
                    }
                    if(gameField.checkGameOver() == true) type = 3;

                }
                if(type == 3) {
                    gc.drawImage(new Image("file:image/To.png"), 0, 0);

                }
                if(type == 4) {
                    gc.drawImage(new Image("file:image/Tw.png"), 0, 0);

                }
            }
        }.start();

        theStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}