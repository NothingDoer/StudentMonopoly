package gui;

import gameLogic.Game;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class PlayersInfoShower {

    private static final StackPane playersInfo = new StackPane();
    public static void showPlayersInfo() {
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(playersInfo);
        playersInfo.setAlignment(Pos.TOP_LEFT);
        playersInfo.setPrefWidth(696);
        playersInfo.setPrefHeight(400);
        playersInfo.setTranslateX(152);
        playersInfo.setTranslateY(50);

        if (Game.getNumberOfPlayers() >= 1) {
            //Saldo gracz niebieski
            ImageView SaldoNiebieski = new ImageView();
            Image SaldoNiebieskiImage = Chooser.chooseImage(Game.getPlayer(0).getPawn().getColor());
            SaldoNiebieski.setImage(SaldoNiebieskiImage);
            SaldoNiebieski.setTranslateX(0);
            SaldoNiebieski.setTranslateY(0);

            //Label dla gracza 1
            Label Gracz1 = new Label(Game.getPlayer(0).isBankrupt() ? "Bankrut" : Game.getPlayer(0).getNick());
            Gracz1.getStyleClass().add("label");
            Gracz1.setTranslateX(5);
            Gracz1.setTranslateY(10);

            //Label_saldo dla gracza niebiskiego
            Label Saldo1 = new Label(Game.getPlayer(0).getMoneyAmount() + "M$");
            Saldo1.getStyleClass().add(Chooser.chooseStyle(Game.getPlayer(0).getPawn().getColor()));
            Saldo1.setTranslateX(25);
            Saldo1.setTranslateY(110);

            playersInfo.getChildren().addAll(SaldoNiebieski, Gracz1, Saldo1);
        }


        if (Game.getNumberOfPlayers() >= 2) {
            //Saldo gracz czerwony
            ImageView SaldoCzerwony = new ImageView();
            Image SaldoCzerwonyImage = Chooser.chooseImage(Game.getPlayer(1).getPawn().getColor());
            SaldoCzerwony.setImage(SaldoCzerwonyImage);
            SaldoCzerwony.setTranslateX(348);
            SaldoCzerwony.setTranslateY(0);

            //Label dla gracza 2
            Label Gracz2 = new Label(Game.getPlayer(1).isBankrupt() ? "Bankrut" : Game.getPlayer(1).getNick());
            Gracz2.getStyleClass().add("label");
            Gracz2.setTranslateX(353);
            Gracz2.setTranslateY(10);

            //Label_saldo dla gracza czerwonego
            Label Saldo2 = new Label(Game.getPlayer(1).getMoneyAmount() + "M$");
            Saldo2.getStyleClass().add(Chooser.chooseStyle(Game.getPlayer(1).getPawn().getColor()));
            Saldo2.setTranslateX(373);
            Saldo2.setTranslateY(100);

            playersInfo.getChildren().addAll(SaldoCzerwony, Gracz2, Saldo2);
        }

        if (Game.getNumberOfPlayers() >= 3) {
            //Saldo gracz zolty
            ImageView SaldoZolty = new ImageView();
            Image SaldoZoltyImage = Chooser.chooseImage(Game.getPlayer(2).getPawn().getColor());
            SaldoZolty.setImage(SaldoZoltyImage);
            SaldoZolty.setTranslateX(0);
            SaldoZolty.setTranslateY(200);

            //Label dla gracza 3
            Label Gracz3 = new Label(Game.getPlayer(2).isBankrupt() ? "Bankrut" : Game.getPlayer(2).getNick());
            Gracz3.getStyleClass().add("label");
            Gracz3.setTranslateX(5);
            Gracz3.setTranslateY(210);

            //Label_saldo dla gracza zoltego
            Label Saldo3 = new Label(Game.getPlayer(2).getMoneyAmount() + "M$");
            Saldo3.getStyleClass().add(Chooser.chooseStyle(Game.getPlayer(2).getPawn().getColor()));
            Saldo3.setTranslateX(25);
            Saldo3.setTranslateY(300);

            playersInfo.getChildren().addAll(SaldoZolty, Gracz3, Saldo3);
        }

        if (Game.getNumberOfPlayers() >= 4) {
            //Saldo gracz zielony
            ImageView SaldoZielony = new ImageView();
            Image SaldoZielonyImage = Chooser.chooseImage(Game.getPlayer(3).getPawn().getColor());
            SaldoZielony.setImage(SaldoZielonyImage);
            SaldoZielony.setTranslateX(348);
            SaldoZielony.setTranslateY(200);

            //Label dla gracza 4
            Label Gracz4 = new Label(Game.getPlayer(3).isBankrupt() ? "Bankrut" : Game.getPlayer(3).getNick());
            Gracz4.getStyleClass().add("label");
            Gracz4.setTranslateX(353);
            Gracz4.setTranslateY(210);


            //Label_saldo dla gracza zielonego
            Label Saldo4 = new Label(Game.getPlayer(3).getMoneyAmount() + "M$");
            Saldo4.getStyleClass().add(Chooser.chooseStyle(Game.getPlayer(3).getPawn().getColor()));
            Saldo4.setTranslateX(373);
            Saldo4.setTranslateY(300);

            playersInfo.getChildren().addAll(SaldoZielony, Gracz4, Saldo4);
        }

        stackPane.getChildren().add(playersInfo);
    }
}
