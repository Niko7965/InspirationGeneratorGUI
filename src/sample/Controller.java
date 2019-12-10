package sample;

import javafx.fxml.FXML;


import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class Controller {
    public ImageView imgButton;
    public ImageView backgroundImg;
    public TextGen textgen = new TextGen();
    @FXML private Text TitleText;
    //@FXML private ImageView imgButton;



    @FXML private void hoverAnimation(MouseEvent event) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("Images/ButtonHover.png");
        Image image = new Image(input);
        imgButton.setImage(image);

    }

    @FXML private void exitAnimation(MouseEvent event) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("Images/Button.png");
        Image image = new Image(input);
        imgButton.setImage(image);

    }

    @FXML private void submit(MouseEvent event){
            TitleText.setText(textgen.getInspiration());


    }
}
