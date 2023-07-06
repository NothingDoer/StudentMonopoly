package gui;

import gameLogic.*;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class PropertyIconsShower {
    private static StackPane propertyIcons = new StackPane();

    private static final int[][] possiblePositions = new int[][]
            {{1675, 828}, {1586, 828}, {1508, 828}, {1430, 828}, {1352, 828}, {1274, 828}, {1196, 828}, {1118, 828}, {1040, 828}, {962, 828},
            {923, 878}, {923, 789}, {923, 711}, {923, 633}, {923, 555}, {923, 477}, {923, 399}, {923, 321}, {923, 243}, {923, 165},
            {873, 126}, {962, 126}, {1040, 126}, {1118, 126}, {1196, 126}, {1274, 126}, {1352, 126}, {1430, 126}, {1508, 126}, {1586, 126},
            {1625, 76}, {1625, 165}, {1625, 243}, {1625, 321}, {1625, 399}, {1625, 477}, {1625, 555}, {1625, 633}, {1625, 711}, {1625, 789}};

    private static void init(){
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(propertyIcons);
        propertyIcons = new StackPane();
        propertyIcons.setMouseTransparent(true);
        stackPane.getChildren().add(propertyIcons);
    }

    public static void showPropertyIcons() {
        init();

        Board board = Game.getBoard();
        for (int i = 0; i < 40; i++) {
            Square square = board.getSquares().get(i);
            if(square instanceof Property property && property.getOwner() != null) {
                ImageView iconImg = new ImageView();
                iconImg.setImage(Chooser.choosePropertyIcon(property));
                iconImg.setTranslateX(possiblePositions[i][0]);
                iconImg.setTranslateY(possiblePositions[i][1]);
                iconImg.setFitWidth(50);
                iconImg.setFitHeight(50);
                propertyIcons.getChildren().add(iconImg);
            }
        }
    }
}
