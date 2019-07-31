/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantsimulation;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author tajfar
 */
public class Tree extends Plant {

    private double thickness;
    private boolean evergreen = true;
    Random random = new Random();

    public Tree(String shape,double distOfPollination) {
        setShape(shape);
        step =0.06;
        height = 100;
        setDistOfPollination(distOfPollination);
        maxOfLongevity = 200;
        setThickness(20.00);
        if (shape.equals("pine")) {
            Image image = new Image(getClass().getResourceAsStream("Pine.png"), 200, 200, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(random.nextInt(50) + 780);
            imageView.setY(random.nextInt(200) + 300);
        } else if (shape.equals("Willow")) {
            Image image = new Image(getClass().getResourceAsStream("Willow.png"), 200, 200, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(random.nextInt(100) +10);
            imageView.setY(random.nextInt(200) + 300);
        }
        x=random.nextInt(50) + 780;
        y=random.nextInt(200) + 300;

    }

    /**
     * @return the thickness
     */
    public double getThickness() {
        return thickness;
    }

    /**
     * @param thickness the thickness to set
     */
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

}
