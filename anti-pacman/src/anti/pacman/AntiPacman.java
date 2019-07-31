/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anti.pacman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author khatere
 */
public class AntiPacman extends Application {

    private static KeyCode direction;
    private static int ghostNumber;
    private Map gameMap;
    private Pacman pacman = new Pacman();
    private Ghost ghost[] = new Ghost[4];

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        gameMap = new Map();
        for (int i = 0; i < ghost.length; i++) {
            ghost[i] = new Ghost();
        }
        gameMap.loadftomfile();
        gameMap.show(root);
        AnimationTimer animationTimer = new AnimationTimer() {
            private long lastTime;

            @Override
            public void handle(long l) {
                if (l - lastTime > 150_000_000) {
                    lastTime = l;
                } else {
                    return;
                }
                pacman.PacmanMove(gameMap);
//                for (int i = 0; i < ghost.length; i++) {
//                    if (i == ghostNumber) {
//                        ghost[i].GhostMove(gameMap,direction,i);
//                    } else {
//                        ghost[i].RandomGhostMove(gameMap,i);
//                    }
//                }
                gameMap.show(root);
            }
        };

        animationTimer.start();
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.UP || t.getCode() == KeyCode.DOWN
                        || t.getCode() == KeyCode.LEFT || t.getCode() == KeyCode.RIGHT) {
                    direction = t.getCode();
                }
                if (t.getCode().isDigitKey()) {
                    int digitValue = Integer.valueOf(t.getCharacter());
                    if (digitValue < ghost.length) {
                        ghostNumber = digitValue;
                    }
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
