package sample;

import javafx.fxml.FXML;


import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;



public class Controller {
    public ImageView imgButton;
    public TextGen textgen = new TextGen();
    @FXML private Text TitleText;
    //@FXML private ImageView imgButton;



    @FXML private void submit(MouseEvent event){
        if(TitleText.getText() != "En grim vinter"){
            TitleText.setText("En grim vinter");

        }
        else{
            TitleText.setText(textgen.getInspiration());

        }

    }
}
