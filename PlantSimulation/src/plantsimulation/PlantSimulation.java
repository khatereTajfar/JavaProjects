/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantsimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import static plantsimulation.Plant.root;

/**
 *
 * @author tajfar
 */
public class PlantSimulation extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

//        playing audio
        Media bird = new Media(getClass().getResource("Birds.mp3").toExternalForm());
        MediaPlayer mediaplayer = new MediaPlayer(bird);
        mediaplayer.setVolume(0.5f);
        mediaplayer.setCycleCount(AudioClip.INDEFINITE);
        mediaplayer.play();

//        back ground image
        Image image = new Image(getClass().getResourceAsStream("Grass.jpg"));
        ImageView imageView = new ImageView(image);
        root.getChildren().add(imageView);
//     file   
        File file = new File("Plants.txt");
        PrintWriter writer = new PrintWriter(file);
//making random number for array length
        Random random = new Random();
        int rnd1 = random.nextInt(10) + 5;
        Plant[] plants = new Plant[rnd1];
        System.out.println("array length=" + plants.length);
//        counters for plants
        int roseCounter = 0;
        int sunFlowerCounter = 0;
        int tulipCounter = 0;
        int treeCounter = 0;

        for (int i = 0; i < plants.length - 4; i++) {
            int rnd = random.nextInt(6) + 10;
            System.out.println("case:" + rnd);
            switch (rnd) {
                case 10:
                    System.out.println("Red Rose");
                    plants[i] = new Rose("red", 5);
                    root.getChildren().add(plants[i].getImageView());
                    plants[i].growthAndDeath(plants[i].step, plants[i].maxOfLongevity);
                    ++roseCounter;
//                    writing documents to file
                    writer.println("SHAPE:" + plants[i].shape + "  COLOR:" + plants[i].color + "  STEP:" + plants[i].step + "  HEIGHT:" + plants[i].height
                            + "  DISTANCE OF POLLINATION:" + plants[i].distOfPollination + "  MAX OF LONGEVITY:" + plants[i].maxOfLongevity);
                    break;
                case 11:
                    System.out.println("Pink Rose");
                    plants[i] = new Rose("pink", 3);
                    root.getChildren().add(plants[i].getImageView());
                    plants[i].growthAndDeath(plants[i].step, plants[i].maxOfLongevity);
                    ++roseCounter;
//                    writing documents to file
                    writer.println("SHAPE:" + plants[i].shape + "  COLOR:" + plants[i].color + "  STEP:" + plants[i].step + "  HEIGHT:" + plants[i].height
                            + "  DISTANCE OF POLLINATION:" + plants[i].distOfPollination + "  MAX OF LONGEVITY:" + plants[i].maxOfLongevity);
                    break;
                case 12:
                    System.out.println("SunFlower");
                    plants[i] = new SunFlower(15);
                    root.getChildren().add(plants[i].getImageView());
                    plants[i].growthAndDeath(plants[i].step, plants[i].maxOfLongevity);
                    ++sunFlowerCounter;
//                    writing documents to file
                    writer.println("SHAPE:" + plants[i].shape + "  COLOR:" + plants[i].color + "  STEP:" + plants[i].step + "  HEIGHT:" + plants[i].height
                            + "  DISTANCE OF POLLINATION:" + plants[i].distOfPollination + "  MAX OF LONGEVITY:" + plants[i].maxOfLongevity);
                    break;
                case 13:
                    System.out.println("Yellow Tulip");
                    plants[i] = new Tulip("yellow", 5);
                    root.getChildren().add(plants[i].getImageView());
                    plants[i].growthAndDeath(plants[i].step, plants[i].maxOfLongevity);
                    ++tulipCounter;
//                   writing documents to file                   
                    writer.println("SHAPE:" + plants[i].shape + "  COLOR:" + plants[i].color + "  STEP:" + plants[i].step + "  HEIGHT:" + plants[i].height
                            + "  DISTANCE OF POLLINATION:" + plants[i].distOfPollination + "  MAX OF LONGEVITY:" + plants[i].maxOfLongevity);
                    break;
                case 14:
                    System.out.println("White Tulip");
                    plants[i] = new Tulip("white", 2);
                    root.getChildren().add(plants[i].getImageView());
                    plants[i].growthAndDeath(plants[i].step, plants[i].maxOfLongevity);
                    ++tulipCounter;
//                    writing documents to file
                    writer.println("SHAPE:" + plants[i].shape + "  COLOR:" + plants[i].color + "  STEP:" + plants[i].step + "  HEIGHT:" + plants[i].height
                            + "  DISTANCE OF POLLINATION:" + plants[i].distOfPollination + "  MAX OF LONGEVITY:" + plants[i].maxOfLongevity);
                    break;
                case 15:
                    System.out.println("Pine");
                    plants[i] = new Tree("pine", 17);
                    root.getChildren().add(plants[i].getImageView());
                    plants[i].growthAndDeath(plants[i].step, plants[i].maxOfLongevity);
                    ++treeCounter;
//                    writing documents to file
                    writer.println("SHAPE:" + plants[i].shape + "  COLOR:" + plants[i].color + "  STEP:" + plants[i].step + "  HEIGHT:" + plants[i].height
                            + "  DISTANCE OF POLLINATION:" + plants[i].distOfPollination + "  MAX OF LONGEVITY:" + plants[i].maxOfLongevity);
                    break;
                case 16:
                    System.out.println("Willow");
                    plants[i] = new Tree("Willow", 23);
                    root.getChildren().add(plants[i].getImageView());
                    plants[i].growthAndDeath(plants[i].step, plants[i].maxOfLongevity);
//                    writing documents to file
                    writer.println("SHAPE:" + plants[i].shape + "  COLOR:" + plants[i].color + "  STEP:" + plants[i].step + "  HEIGHT:" + plants[i].height
                            + "  DISTANCE OF POLLINATION:" + plants[i].distOfPollination + "  MAX OF LONGEVITY:" + plants[i].maxOfLongevity);
                    break;
            }
            for (int j = plants.length - 4; j <= plants.length; j++) {
                if (plants[i].getClass().getSimpleName().equals("Rose") && roseCounter >= 2 && plants[i].readyForReproduct) {
                    plants[j].reproduction(plants[i].x, plants[i].y, "Rose", plants[i].distOfPollination);
                } else if (plants[i].getClass().getSimpleName().equals("SunFlower") && sunFlowerCounter >= 2 && plants[i].readyForReproduct) {
                    plants[j].reproduction(plants[i].x, plants[i].y, "SunFlower", plants[i].distOfPollination);
                } else if (plants[i].getClass().getSimpleName().equals("Tulip") && tulipCounter >= 2 && plants[i].readyForReproduct) {
                    plants[j].reproduction(plants[i].x, plants[i].y, "Tulip", plants[i].distOfPollination);
                } else if (plants[i].getClass().getSimpleName().equals("Tree") && tulipCounter >= 2 && plants[i].readyForReproduct) {
                    plants[j].reproduction(plants[i].x, plants[i].y, plants[i].shape, plants[i].distOfPollination);
                }

            }

        }
        System.out.println("-----------------------------------------");
        System.out.println("Roses:" + roseCounter + "  SunFlowers:" + sunFlowerCounter + "  Tulips:" + tulipCounter + "  Trees:" + treeCounter);

        writer.close();
        Scene scene = new Scene(root, 1800, 700);
        primaryStage.setTitle("Garden");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

}
