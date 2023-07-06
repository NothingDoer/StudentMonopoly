package gui;

import gameLogic.Game;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class CardShower {
    private static StackPane card = new StackPane();

    public static void showCard() {
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(card);
        card = new StackPane();
        card.setAlignment(Pos.CENTER);
        card.setPrefWidth(640);
        card.setPrefHeight(400);
        card.setTranslateX(979);
        card.setTranslateY(301);

        ImageView CardImgView = new ImageView();
        Image CardImg = new Image("file:../../assets/" + Game.getBoard().getDrawnCard().getName() + ".png");
        CardImgView.setImage(CardImg);
        CardImgView.setFitWidth(640);
        CardImgView.setFitHeight(400);
        card.getChildren().add(CardImgView);

        stackPane.getChildren().add(card);
    }

    public static void removeCard() {
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(card);
    }
}
