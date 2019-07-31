/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anti.pacman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author khatere
 */
class Map {

    char map[][] = new char[30][30];
    private static final int SIZE = 25;

    void loadftomfile() {
        BufferedReader br = null;

        int count = 0;
        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("C:\\Users\\khatere\\Desktop\\pacman\\map.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                map[count] = sCurrentLine.toCharArray();
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void show(Group root) {
        root.getChildren().clear();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Rectangle rec = new Rectangle(j * SIZE, i * SIZE, SIZE, SIZE);
                root.getChildren().add(rec);
                Circle cir0 = new Circle(j * SIZE + SIZE / 2, i * SIZE + SIZE / 2, SIZE / 3);
                root.getChildren().add(cir0);
                if (map[i][j] == '#') {
                    rec.setFill(Color.GREEN);
                } else if (map[i][j] == '.') {
                    Circle circle = new Circle(j * SIZE + SIZE / 2, i * SIZE + SIZE / 2, SIZE / 9, Color.YELLOW);
                    root.getChildren().add(circle);
                } else if (map[i][j] == '0') {
                    rec.setFill(Color.BLUE);
                } else if (map[i][j] == '@') {
                    System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    Circle cir = new Circle(j * SIZE + SIZE / 2, i * SIZE + SIZE / 2, SIZE / 3);
                    root.getChildren().add(cir);
                    cir.setFill(Color.ORANGE);
                } else if (map[i][j] == '1') {
                    Circle cir1 = new Circle(j * SIZE + SIZE / 2, i * SIZE + SIZE / 2, SIZE / 3);
                    root.getChildren().add(cir1);
                    cir1.setFill(Color.AQUA);
                } else if (map[i][j] == '2') {
                    Circle cir2 = new Circle(j * SIZE + SIZE / 2, i * SIZE + SIZE / 2, SIZE / 3);
                    root.getChildren().add(cir2);
                    cir2.setFill(Color.AQUAMARINE);
                } else if (map[i][j] == '3') {
                    Circle cir3 = new Circle(j * SIZE + SIZE / 2, i * SIZE + SIZE / 2, SIZE / 3);
                    root.getChildren().add(cir3);
                    cir3.setFill(Color.BLUE);
                } else if (map[i][j] == '4') {
                    Circle cir4 = new Circle(j * SIZE + SIZE / 2, i * SIZE + SIZE / 2, SIZE / 3);
                    root.getChildren().add(cir4);
                    cir4.setFill(Color.BLUEVIOLET);
                } else if (map[i][j] == '5') {
                    Circle cir5 = new Circle(j * SIZE + SIZE / 2, i * SIZE + SIZE / 2, SIZE / 5, Color.YELLOW);
                    root.getChildren().add(cir5);

                }
            }
        }
    }
//    check directions for walls

    int CheckUp(int x, int y) {
        if (map[x - 1][y] == '#') {
            return 1;
        } else {
            return 0;
        }
    }

    int CheckDown(int x, int y) {
        if (map[x + 1][y] == '#') {
            return 1;
        } else {
            return 0;
        }
    }

    int CheckRight(int x, int y) {
        if (map[x][y + 1] == '#') {
            return 1;
        } else {
            return 0;
        }
    }

    int CheckLeft(int x, int y) {
        if (map[x][y - 1] == '#') {
            return 1;
        } else {
            return 0;
        }
    }
//    check directions for Dots
    int DotCheckUp(int x,int y){
        if(map[x-1][y]=='.')
            return 1;
        else
            return 0;
    }
    int DotCheckRight(int x,int y){
        if(map[x][y+1]=='.')
            return 1;
        else
            return 0;
    }
    int DotCheckDown(int x,int y){
        if(map[x+1][y]=='.')
            return 1;
        else
            return 0;
    }
    int DotCheckLeft(int x,int y){
        if(map[x][y-1]=='.')
            return 1;
        else
            return 0;
    }
}
