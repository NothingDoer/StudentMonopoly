package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class ErrorShower {
    private static StackPane errorBox = new StackPane();

    public static void showError(String errorMessage) {

        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(errorBox);
        errorBox.setAlignment(Pos.CENTER);
        errorBox.setPrefWidth(500);
        errorBox.setPrefHeight(200);
        errorBox.setTranslateX(20);
        errorBox.setTranslateY(0);

        //Karta
        Rectangle okno = new Rectangle(500, 200);
        okno.getStyleClass().add("pasek");

        Button closeButton = new Button("X");
        closeButton.setOnAction(event -> closeError());
        closeButton.setTranslateX(235);
        closeButton.setTranslateY(-85);

        //Nazwa
        Label text = new Label(errorMessage);
        text.getStyleClass().add("nazwa");
        text.setTranslateX(0);
        text.setTranslateY(0);

        errorBox.getChildren().addAll(okno, text, closeButton);

        stackPane.getChildren().add(errorBox);
    }

    public static void closeError() {
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(errorBox);
        errorBox = new StackPane();
    }
}
