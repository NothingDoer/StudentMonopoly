package gui;

import gameLogic.Game;
import gameLogic.GameType;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class GameShower {
    public static void showGame() {
        Pane root = new Pane();

        Image BackgroundImage = new Image("file:../../assets/Tlo.png");

        BackgroundImage backgroundImage = new BackgroundImage(
                BackgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background background = new Background(backgroundImage);

        root.setBackground(background);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm());

        ScreenSettings.resize(scene);
        ScreenSettings.primaryStage.setScene(scene);

        BoardShower.showBoard();
        PlayersInfoShower.showPlayersInfo();
        if(Game.getGameType() == GameType.MultiplayerHost || Game.getGameType() == GameType.Singleplayer) {
            DecisionButtonsShower.showGameStartButton();
        }
    }
}
