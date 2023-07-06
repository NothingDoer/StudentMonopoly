package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class DicesShower {
    private static StackPane dices = new StackPane();

    private static void init(){
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(dices);
        dices = new StackPane();
        dices.setAlignment(Pos.CENTER);
        dices.setPrefWidth(696);
        dices.setPrefHeight(200);
        dices.setTranslateX(152);
        dices.setTranslateY(752);
        stackPane.getChildren().add(dices);
    }

    public static void showDices(ArrayList<Integer> dicesNumbers) {
        init();

        if(dicesNumbers.size() >= 1){
            ImageView Kostka1 = new ImageView();
            Image Kostka1Image = Chooser.chooseDice(dicesNumbers.get(0));
            Kostka1.setImage(Kostka1Image);
            Kostka1.setTranslateX(-150);
            Kostka1.setTranslateY(0);
            dices.getChildren().addAll(Kostka1);
        }

        if(dicesNumbers.size() >= 2) {
            ImageView Kostka2 = new ImageView();
            Image Kostka2Image = Chooser.chooseDice(dicesNumbers.get(1));
            Kostka2.setImage(Kostka2Image);
            Kostka2.setTranslateX(150);
            Kostka2.setTranslateY(0);
            dices.getChildren().addAll(Kostka2);
        }

        if(dicesNumbers.size() >= 3) {
            ImageView Kostka3 = new ImageView();
            Image Kostka2Image = Chooser.chooseDice(dicesNumbers.get(2));
            Kostka3.setImage(Kostka2Image);
            Kostka3.setTranslateX(0);
            Kostka3.setTranslateY(0);
            dices.getChildren().addAll(Kostka3);
        }
    }
}
