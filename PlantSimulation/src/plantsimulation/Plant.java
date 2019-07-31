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
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author tajfar
 */
public class Plant {

    public static Group root = new Group();
    private ImageView imageView;
    protected String shape;
    protected double step;
    protected double height;
    protected double distOfPollination;
    protected double maxOfLongevity;
    protected String color;
    double live = 0;
    double x;
    double y;
    boolean grow = false;
    boolean shrink = false;
    boolean readyForReproduct = false;

    Random random = new Random();

    /**
     * @return the shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * @param shape the shape to set
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * @return the step
     */
    public double getStep() {
        return step;
    }

    /**
     * @param step the step to set
     */
    public void setStep(double step) {
        this.step = step;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the distOfPollination
     */
    public double getDistOfPollination() {
        return distOfPollination;
    }

    /**
     * @param distOfPollination the distOfPollination to set
     */
    public void setDistOfPollination(double distOfPollination) {
        this.distOfPollination = distOfPollination;
    }

    /**
     * @return the maxOfLongevity
     */
    public double getMaxOfLongevity() {
        return maxOfLongevity;
    }

    /**
     * @param maxOfLongevity the maxOfLongevity to set
     */
    public void setMaxOfLongevity(double maxOfLongevity) {
        this.maxOfLongevity = maxOfLongevity;
    }

    /**
     * @return the imageView
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * @param imageView the imageView to set
     */
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    public void growthAndDeath(double step, double maxOfLongevity) {
        AnimationTimer animationtimer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (!grow && !shrink) {
                    imageView.setFitHeight(imageView.getFitHeight() + step);
                    imageView.setFitWidth(imageView.getFitWidth() + step);
                    live = live + step;
                    if (live >= maxOfLongevity / 2) {
                        readyForReproduct = true;
                    }
                    if (live >= maxOfLongevity) {
                        grow = true;
                    }
                } else if (grow && !shrink) {
                    imageView.setFitHeight(imageView.getFitHeight() - 2 * step);
                    imageView.setFitWidth(imageView.getFitWidth() - 2 * step);
                    if (imageView.getFitHeight() <= 30 || imageView.getFitWidth() <= 30) {
                        shrink = true;
                        getImageView().setVisible(false);
                    }
                }

            }
        };
        animationtimer.start();
    }

    public void reproduction(double x, double y, String shape, double distOfPollination) {
        if (shape.equals("Rose") && random.nextBoolean() && distOfPollination <= 5) {
            Image image = new Image(getClass().getResourceAsStream("RedRose.png"), 70, 70, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(x / 2);
            imageView.setY(y / 2);

        } else if (shape.equals("Rose") && !random.nextBoolean() && distOfPollination <= 5) {
            Image image = new Image(getClass().getResourceAsStream("PinkRose.png"), 70, 70, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(x / 2);
            imageView.setY(y / 2);
        } else if (shape.equals("SunFlower") && distOfPollination <= 15) {
            Image image = new Image(getClass().getResourceAsStream("sunFlower.png"), 70, 70, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(x / 2);
            imageView.setY(y / 2);
        } else if (shape.equals("Tulip") && random.nextBoolean() && distOfPollination <= 5) {
            Image image = new Image(getClass().getResourceAsStream("YellowTulip.png"), 60, 60, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(x / 2);
            imageView.setY(y / 2);
        } else if (shape.equals("Tulip") && !random.nextBoolean() && distOfPollination <= 5) {
            Image image = new Image(getClass().getResourceAsStream("WhiteTulip.png"), 60, 60, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(x / 2);
            imageView.setY(y / 2);
        } else if (shape.equals("pine") && distOfPollination <= 30) {
            Image image = new Image(getClass().getResourceAsStream("Pine.png"), 200, 200, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(x / 2);
            imageView.setY(y / 2);
        } else if (shape.equals("Willow") && distOfPollination <= 30) {
            Image image = new Image(getClass().getResourceAsStream("Willow.png"), 200, 200, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(x / 2);
            imageView.setY(y / 2);
        }
    }
}
