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
public class Rose extends Plant {

    private boolean odorous = true;
    private String color;
    Random random = new Random();

    
    public Rose(String color,double distOfPollination) {
        shape = "Rose";
        step =0.02;
        height = 30;
        setDistOfPollination(distOfPollination);
        maxOfLongevity = 60;
        setColor(color);
        if (color.equals("red")) {

            Image image = new Image(getClass().getResourceAsStream("RedRose.png"), 70, 70, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(random.nextInt(100) + 340);
            imageView.setY(random.nextInt(100) + 400);
        } else if (color.equals("pink")) {
            Image image = new Image(getClass().getResourceAsStream("PinkRose.png"), 70, 70, true, true);
            ImageView imageView = new ImageView(image);
            setImageView(imageView);
            imageView.setX(random.nextInt(100) + 460);
            imageView.setY(random.nextInt(90) + 440);
        }
        x=random.nextInt(100) + 20;
        y=random.nextInt(100) + 100;

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
