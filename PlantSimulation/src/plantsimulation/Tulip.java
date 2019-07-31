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
public class Tulip extends Plant {

    private boolean odorous;
    private String color;
    Random random = new Random();

    public Tulip(String color,double distOfPollination) {
        shape = "Tulip";
        step =0.02;
        height = 30;
        setDistOfPollination(distOfPollination);
        maxOfLongevity = 50;
        setColor(color);
        if (color.equals("yellow")) {
            Image image = new Image(getClass().getResourceAsStream("YellowTulip.png"), 70, 70, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(random.nextInt(300) + 600);
            imageView.setY(random.nextInt(40) + 140);
        } else if (color.equals("white")) {
            Image image = new Image(getClass().getResourceAsStream("WhiteTulip.png"), 80, 80, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(random.nextInt(450) + 430);
            imageView.setY(random.nextInt(240) + 270);
        }
        x=random.nextInt(300) + 620;
        y=random.nextInt(40) + 150;

    }

    /**
     * @return the odorous
     */
    public boolean isOdorous() {
        return odorous;
    }

    /**
     * @param odorous the odorous to set
     */
    public void setOdorous(boolean odorous) {
        this.odorous = odorous;
    }

}
