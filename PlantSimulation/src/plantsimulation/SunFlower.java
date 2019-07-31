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
public class SunFlower extends Plant {

    private boolean odorous = false;
    Random random = new Random();

    
    public SunFlower(double distOfPollination) {
        shape = "SunFlower";
        step =0.03;
        height = 50;
        setDistOfPollination(distOfPollination);
        maxOfLongevity = 90;
        Image image = new Image(getClass().getResourceAsStream("sunFlower.png"), 70, 70, true, true);
        ImageView imageView = new ImageView(image);
        setImageView(imageView);
        imageView.setX(random.nextInt(150) +410);
        imageView.setY(random.nextInt(460) + 130);
        x=random.nextInt(150) +410;
        y=random.nextInt(460) + 250;
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

    /**
     * @return the color
     */
    
}
