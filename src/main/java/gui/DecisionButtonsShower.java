package gui;

import gameLogic.Game;
import gameLogic.GameInfo;
import gameLogic.Player;
import gameLogic.Property;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class DecisionButtonsShower {
    private static StackPane decisionButtons = new StackPane();
    private static StackPane backButton = new StackPane();

    private static void init(){
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(decisionButtons);
        decisionButtons = new StackPane();
        decisionButtons.setAlignment(Pos.CENTER);
        decisionButtons.setPrefWidth(696);
        decisionButtons.setPrefHeight(262);
        decisionButtons.setTranslateX(152);
        decisionButtons.setTranslateY(490);
        stackPane.getChildren().add(decisionButtons);
    }

    public static void showGameStartButton() {
        init();

        Button button1;
        button1 = new Button("Rozpocznij gre");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> DecisionButtonsController.onStartGameButtonClick());
        decisionButtons.getChildren().add(button1);
    }

    public static void showRoundStartDecisionButtons() {
        init();

        Button button1;
        button1 = new Button("Rzuc koscmi");
        button1.setTranslateY(-50);
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> DecisionButtonsController.onDicesButtonClick());
        decisionButtons.getChildren().add(button1);

        Button button2 = null;
        if(Game.getActivePlayer().canSellOrDegradeSomething() && Game.getActivePlayer().getInDante() <= 0){
            button2 = new Button("Sprzedaj");
            button2.setTranslateY(100);
            button2.getStyleClass().add("przyciski_losowania");
            button2.setOnAction(event -> DecisionButtonsController.onActivateSellModeButtonClick());
            decisionButtons.getChildren().add(button2);
        }

        if(Game.getActivePlayer().canUpgradeSomething() && Game.getActivePlayer().getInDante() <= 0){
            Button button3;
            button3 = new Button("Ulepsz");
            button3.setTranslateY(100);
            if(button2 != null){
                button2.setTranslateX(150);
                button3.setTranslateX(-150);
            }
            button3.getStyleClass().add("przyciski_losowania");
            button3.setOnAction(event -> DecisionButtonsController.onActivateUpgradeModeButtonClick());
            decisionButtons.getChildren().add(button3);
        }
    }

    public static void showBuyDecisionButtons() {
        init();

        Label label = new Label("Czy chcesz kupic to pole?");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        if(Game.getActivePlayer().getMoneyAmount() >= ((Property)Game.getBoard().getSquares().get(Game.getActivePlayer().getPawn().getPosition())).getPrice()){
            Button button1;
            button1 = new Button("Kup");
            button1.getStyleClass().add("przyciski_losowania");
            button1.setTranslateX(-100);
            button1.setOnAction(event -> DecisionButtonsController.onBuyButtonClick());
            decisionButtons.getChildren().add(button1);
        }

        Button button2;
        button2 = new Button("Pomin");
        button2.getStyleClass().add("przyciski_losowania");
        button2.setTranslateX(100);
        button2.setOnAction(event -> DecisionButtonsController.onSkipBuyingButtonClick());
        decisionButtons.getChildren().add(button2);
    }

    public static void showPayDecisionButtons(Player payer, Player receiver, int amount) {
        init();

        if(receiver != null && receiver.getInDante() > 0) {
            Label label = new Label("Gracz siedzi w wiezieniu i nie moze pobrac od ciebie oplaty");
            label.getStyleClass().add("nazwa");
            label.setTranslateX(0);
            label.setTranslateY(-100);
            decisionButtons.getChildren().add(label);

            Button button1;
            button1 = new Button("Ok");
            button1.getStyleClass().add("przyciski_losowania");
            button1.setOnAction(event -> DecisionButtonsController.onDontNeedToPayButtonClick());
            decisionButtons.getChildren().add(button1);
            return;
        }

        if(receiver != null && receiver.isHasElectricDeficiency()) {
            Label label = new Label("Gracz nie ma pradu i nie moze pobrac od ciebie oplaty");
            label.getStyleClass().add("nazwa");
            label.setTranslateX(0);
            label.setTranslateY(-100);
            decisionButtons.getChildren().add(label);

            Button button1;
            button1 = new Button("Ok");
            button1.getStyleClass().add("przyciski_losowania");
            button1.setOnAction(event -> DecisionButtonsController.onDontNeedToPayButtonClick());
            decisionButtons.getChildren().add(button1);
            return;
        }

        if(payer.getOnErasmus() > 0) {
            Label label = new Label("Jestes na erazmusie i nie musisz za nic placic");
            label.getStyleClass().add("nazwa");
            label.setTranslateX(0);
            label.setTranslateY(-100);
            decisionButtons.getChildren().add(label);

            Button button1;
            button1 = new Button("Ok");
            button1.getStyleClass().add("przyciski_losowania");
            button1.setOnAction(event -> DecisionButtonsController.onDontNeedToPayButtonClick());
            decisionButtons.getChildren().add(button1);
            return;
        }

        Label label = new Label("Placisz " + (receiver == null ? "do banku" : "graczowi" + receiver.getNick()) + " " + amount + " M$");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        if(payer.getMoneyAmount() >= amount){
            Button button1;
            button1 = new Button("Zaplac");
            button1.getStyleClass().add("przyciski_losowania");
            button1.setOnAction(event -> DecisionButtonsController.onPayToPlayerButtonClick(payer, receiver, amount));
            decisionButtons.getChildren().add(button1);
        }
        else{
            Button button2;
            Label label2 = new Label("Sprzedaj pola/ulepszenia by starczylo na oplaty");
            label2.getStyleClass().add("nazwa");
            label2.setTranslateX(0);
            label2.setTranslateY(-50);
            decisionButtons.getChildren().add(label2);
            button2 = new Button("Sprzedaj");
            button2.setTranslateY(50);
            button2.getStyleClass().add("przyciski_losowania");
            button2.setOnAction(event -> DecisionButtonsController.onActivateNeedToSellModeButtonClick(payer, receiver, amount));
            decisionButtons.getChildren().add(button2);
        }
    }

    public static void showGoToDanteDecisionButtons() {
        init();

        Label label = new Label("Idziesz robic Dante! Konczysz ture.");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        Button button1;
        button1 = new Button("Ok");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> DecisionButtonsController.onGoToDanteOkButtonClick());
        decisionButtons.getChildren().add(button1);
    }

    public static void showInDanteDecisionButtons(boolean hasCard) {
        init();

        Label label = new Label("Robisz Dante jeszcze przez " + Game.getActivePlayer().getInDante() + "tury.");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        Button button1;
        button1 = new Button("Rzuc koscmi");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> DecisionButtonsController.onDicesInDanteButtonClick());
        decisionButtons.getChildren().add(button1);

        if(Game.getActivePlayer().getMoneyAmount() >= GameInfo.LEAVE_DANTE_PAY){
            button1.setTranslateX(-200);

            Button button2;
            button2 = new Button("Zaplac " + GameInfo.LEAVE_DANTE_PAY + "M$");
            button2.getStyleClass().add("przyciski_losowania");
            button2.setTranslateX(150);
            button2.setOnAction(event -> DecisionButtonsController.onPayInDanteButtonClick());
            decisionButtons.getChildren().add(button2);
        }

        if(hasCard){
            Button button3;
            button3 = new Button("Uzyj karty");
            button3.getStyleClass().add("przyciski_losowania");
            button3.setTranslateY(100);
            button3.setOnAction(event -> DecisionButtonsController.onUseCardInDanteButtonClick());
            decisionButtons.getChildren().add(button3);
        }
    }

    public static void showDrawCardDecisionButtons() {
        init();

        Label label = new Label("Dobierasz karte.");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        Button button1;
        button1 = new Button("Ok");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> DecisionButtonsController.onDrawCardButtonClick());
        decisionButtons.getChildren().add(button1);
    }

    public static void showDoCardActionDecisionButtons() {
        init();

        Label label = new Label("Wykonaj akcje na karcie.");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        Button button1;
        button1 = new Button("Ok");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> DecisionButtonsController.onDoCardActionButtonClick());
        decisionButtons.getChildren().add(button1);
    }


    public static void showCardGoodGradeDecisionButtons() {
        init();

        Label label = new Label("Wybierz w ktora strone chcesz sie ruszyc:");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        Button button1;
        button1 = new Button("Wstecz");
        button1.setTranslateX(-200);
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> DecisionButtonsController.onDoCardGoodGradeActionButtonClick(-3));
        decisionButtons.getChildren().add(button1);

        Button button2;
        button2 = new Button("Przod");
        button2.setTranslateX(150);
        button2.getStyleClass().add("przyciski_losowania");
        button2.setOnAction(event -> DecisionButtonsController.onDoCardGoodGradeActionButtonClick(3));
        decisionButtons.getChildren().add(button2);
    }

    public static void showCardBustedDecisionButtons() {
        init();

        Label label = new Label("Wybierz gracza:");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        int i = 0;
        for (Player player : Game.getPlayers()) {
            if(!player.isBankrupt() && player.getInDante() <= 0) {
                Button button1;
                button1 = new Button(player.getNick());
                if(i == 0 || i == 1) {
                    button1.setTranslateY(-25);
                }
                else {
                    button1.setTranslateY(125);
                }
                if(i == 0 || i == 2) {
                    button1.setTranslateX(-200);
                }
                else {
                    button1.setTranslateX(150);
                }
                button1.getStyleClass().add("przyciski_losowania");
                int finalI = i;
                button1.setOnAction(event -> DecisionButtonsController.onDoCardBustedActionButtonClick(finalI));
                decisionButtons.getChildren().add(button1);
            }
            i++;
        }
    }

    public static void showEndRoundDecisionButtons() {
        init();

        Label label = new Label("Konczysz ture.");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        Button button1;
        button1 = new Button("Ok");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> DecisionButtonsController.onEndTurnOkButtonClick());
        decisionButtons.getChildren().add(button1);
    }

    public static void showBankruptDecisionButtons() {
        init();

        Label label = new Label("Splajtowales! Odpadasz z gry.");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        Button button1;
        button1 = new Button("Ok");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> DecisionButtonsController.onBankruptOkButtonClick());
        decisionButtons.getChildren().add(button1);
    }

    public static void showWinDecisionButtons() {
        init();

        Label label = new Label(Game.checkWinner().getNick() + " wygral!!!");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        Button button1;
        button1 = new Button("Menu");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> DecisionButtonsController.onEndGameButtonClick());
        decisionButtons.getChildren().add(button1);
    }

    public static void showBackToInfoModeButton() {
        decisionButtons.setVisible(false);
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(backButton);
        backButton = new StackPane();
        backButton.setAlignment(Pos.CENTER);
        backButton.setPrefWidth(696);
        backButton.setPrefHeight(262);
        backButton.setTranslateX(152);
        backButton.setTranslateY(490);
        stackPane.getChildren().add(backButton);

        Button button1;
        button1 = new Button("Powrot");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> DecisionButtonsController.onBackToInfoModeButtonClick());
        backButton.getChildren().add(button1);
    }

    public static void removeDecisionButtons(){
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(decisionButtons);
    }

    public static void removeBackToInfoModeButton() {
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(backButton);
        decisionButtons.setVisible(true);
    }

    public static void showBackToPaymentButton(Player payer, Player receiver, int amount) {
        decisionButtons.setVisible(false);
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(backButton);
        backButton = new StackPane();
        backButton.setAlignment(Pos.CENTER);
        backButton.setPrefWidth(696);
        backButton.setPrefHeight(262);
        backButton.setTranslateX(152);
        backButton.setTranslateY(490);
        stackPane.getChildren().add(backButton);

        Button button1;
        button1 = new Button("Powrot");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> DecisionButtonsController.onBackToPaymentButtonClick(payer, receiver, amount));
        backButton.getChildren().add(button1);
    }
}
