package gui;

import gameLogic.Game;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ActivePlayerInfoShower {
    private static StackPane activePlayerInfo = new StackPane();
    private static void init(){
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(activePlayerInfo);
        activePlayerInfo = new StackPane();
        activePlayerInfo.setAlignment(Pos.CENTER);
        activePlayerInfo.setPrefWidth(696);
        activePlayerInfo.setPrefHeight(40);
        activePlayerInfo.setTranslateX(152);
        activePlayerInfo.setTranslateY(450);
        stackPane.getChildren().add(activePlayerInfo);
    }

    public static void showActivePlayerInfo() {
        init();

        Label playerName = new Label("Tura gracza: " + Game.getActivePlayer().getNick());
        playerName.getStyleClass().add("nazwa");
        activePlayerInfo.getChildren().add(playerName);
    }
}
