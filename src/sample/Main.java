package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setOpacity(1);


        primaryStage.show();
    }


    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
        /*
        public ArrayList<String> characterlist = new ArrayList<String>();
        Scanner scan = new Scanner(new File("files/TheCharacter.txt"));
        while(scan.hasNextLine()){
            characterlist.add(scan.nextLine());
        }
        scan.close();
        System.out.println(characterlist.get(5));
        */
    }
}
