package gui;

import gameLogic.Game;
import gameLogic.Pawn;
import gameLogic.Player;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class PawnsShower {
    private static StackPane pawns = new StackPane();

    private static final int[][] possiblePositions = new int[][]
            {{1685, 888}, {1596, 888}, {1518, 888}, {1440, 888}, {1362, 888}, {1284, 888}, {1206, 888}, {1128, 888}, {1050, 888}, {972, 888},
            {883, 888}, {883, 799}, {883, 721}, {883, 643}, {883, 565}, {883, 487}, {883, 409}, {883, 331}, {883, 253}, {883, 175},
            {883, 86}, {972, 86}, {1050, 86}, {1128, 86}, {1206, 86}, {1284, 86}, {1362, 86}, {1440, 86}, {1518, 86}, {1596, 86},
            {1685, 86}, {1685, 175}, {1685, 253}, {1685, 331}, {1685, 409}, {1685, 487}, {1685, 565}, {1685, 643}, {1685, 721}, {1685, 799}};

    public static void showPawns() {
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(pawns);
        pawns = new StackPane();
        pawns.setMouseTransparent(true);

        for (Player player : Game.getPlayers()) {
            if(!player.isBankrupt()){
                ImageView pawnImg = new ImageView();
                Pawn pawn = player.getPawn();
                pawnImg.setImage(Chooser.choosePawn(pawn.getColor()));
                pawnImg.setTranslateX(possiblePositions[pawn.getPosition()][0]);
                pawnImg.setTranslateY(possiblePositions[pawn.getPosition()][1]);
                pawnImg.setFitWidth(30);
                pawnImg.setFitHeight(30);
                pawns.getChildren().add(pawnImg);
            }
        }

        stackPane.getChildren().add(pawns);
    }
}
