package gui;

import gameLogic.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MenuShower {

    public static void showMainMenu() {
        // Tworzenie obiektu MenuPowitlane
        ImageView MenuPowitalne = new ImageView();

        // Wczytywanie obrazu
        Image MenuPowitlaneImage = new Image("file:../../assets/MenuPowitalne.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        MenuPowitalne.setImage(MenuPowitlaneImage);
        MenuPowitalne.setFitWidth(ScreenSettings.screenWidth);
        MenuPowitalne.setFitHeight(ScreenSettings.screenHeight);

        // Tworzenie przycisku 1
        Button button1 = new Button("Rozpocznij gre");
        button1.getStyleClass().add("przyciski_menu_powitalne");
        button1.setTranslateX(20);
        button1.setTranslateY(110);
        button1.setOnAction(event -> MenuController.onPlayButtonClick());

        // Tworzenie przycisku 2
        Button button2 = new Button("Ustawienia");
        button2.getStyleClass().add("przyciski_menu_powitalne");
        button2.setTranslateX(20);
        button2.setTranslateY(130);
        button2.setOnAction(event -> MenuController.onSettingsButtonClick());

        // Tworzenie przycisku 3
        Button button3 = new Button("Wyjscie");
        button3.getStyleClass().add("przyciski_menu_powitalne");
        button3.setTranslateX(20);
        button3.setTranslateY(150);
        button3.setOnAction(event -> MenuController.onExitButtonClick());

        // Tworzenie kontenera VBox i ustawianie przycisków na środku
        VBox buttonContainer = new VBox(10, button1, button2, button3);
        buttonContainer.setAlignment(Pos.CENTER);

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(MenuPowitalne, buttonContainer);

        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, MenuPowitlaneImage.getWidth(), MenuPowitlaneImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.resize(scene);
        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();
    }

    public static void showMultiOrSingleMenu() {
        // Tworzenie obiektu MenuPowitlane
        ImageView MenuPowitalne = new ImageView();

        // Wczytywanie obrazu
        Image MenuPowitlaneImage = new Image("file:../../assets/MenuPowitalne.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        MenuPowitalne.setImage(MenuPowitlaneImage);
        MenuPowitalne.setFitWidth(ScreenSettings.screenWidth);
        MenuPowitalne.setFitHeight(ScreenSettings.screenHeight);

        // Tworzenie przycisku 1
        Button button1 = new Button("Singleplayer");
        button1.getStyleClass().add("przyciski_menu_powitalne");
        button1.setTranslateX(20);
        button1.setTranslateY(110);
        button1.setOnAction(event -> MenuController.onSingleplayerButtonClick());

        // Tworzenie przycisku 2
        Button button2 = new Button("Muliplayer");
        button2.getStyleClass().add("przyciski_menu_powitalne");
        button2.setTranslateX(20);
        button2.setTranslateY(130);
        button2.setOnAction(event -> MenuController.onMultiplayerButtonClick());

        // Tworzenie przycisku 3
        Button button3 = new Button("Powrot");
        button3.getStyleClass().add("przyciski_menu_powitalne");
        button3.setTranslateX(20);
        button3.setTranslateY(150);
        button3.setOnAction(event -> MenuController.onReturnToMainMenuButtonClick());

        // Tworzenie kontenera VBox i ustawianie przycisków na środku
        VBox buttonContainer = new VBox(10, button1, button2, button3);
        buttonContainer.setAlignment(Pos.CENTER);

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(MenuPowitalne, buttonContainer);

        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, MenuPowitlaneImage.getWidth(), MenuPowitlaneImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.resize(scene);
        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();
    }
    public static void showSettingsMenu() {
        // Tworzenie obiektu MenuPowitlane
        ImageView MenuPowitalne = new ImageView();

        // Wczytywanie obrazu
        Image MenuPowitlaneImage = new Image("file:../../assets/MenuPowitalne.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        MenuPowitalne.setImage(MenuPowitlaneImage);
        MenuPowitalne.setFitWidth(ScreenSettings.screenWidth);
        MenuPowitalne.setFitHeight(ScreenSettings.screenHeight);

        // Tworzenie przycisku 1
        Button button1 = new Button("powieksz obraz");
        button1.getStyleClass().add("przyciski_menu_powitalne");
        button1.setTranslateX(20);
        button1.setTranslateY(110);
        button1.setOnAction(event -> MenuController.onResizeButtonClick(0.05));

        // Tworzenie przycisku 2
        Button button2 = new Button("pomniejsz obraz");
        button2.getStyleClass().add("przyciski_menu_powitalne");
        button2.setTranslateX(20);
        button2.setTranslateY(130);
        button2.setOnAction(event -> MenuController.onResizeButtonClick(-0.05));

        // Tworzenie przycisku 3
        Button button3 = new Button("Powrot");
        button3.getStyleClass().add("przyciski_menu_powitalne");
        button3.setTranslateX(20);
        button3.setTranslateY(150);
        button3.setOnAction(event -> MenuController.onReturnToMainMenuButtonClick());

        // Tworzenie kontenera VBox i ustawianie przycisków na środku
        VBox buttonContainer = new VBox(10, button1, button2, button3);
        buttonContainer.setAlignment(Pos.CENTER);

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(MenuPowitalne, buttonContainer);

        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, MenuPowitlaneImage.getWidth(), MenuPowitlaneImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.resize(scene);
        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();
    }
    public static void showHostOrJoinMenu() {
        // Tworzenie obiektu MenuPowitlane
        ImageView MenuPowitalne = new ImageView();

        // Wczytywanie obrazu
        Image MenuPowitlaneImage = new Image("file:../../assets/MenuPowitalne.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        MenuPowitalne.setImage(MenuPowitlaneImage);
        MenuPowitalne.setFitWidth(ScreenSettings.screenWidth);
        MenuPowitalne.setFitHeight(ScreenSettings.screenHeight);

        // Tworzenie przycisku 1
        Button button1 = new Button("Hostuj");
        button1.getStyleClass().add("przyciski_menu_powitalne");
        button1.setTranslateX(20);
        button1.setTranslateY(110);
        button1.setOnAction(event -> MenuController.onHostButtonClick());

        // Tworzenie przycisku 2
        Button button2 = new Button("Dolacz");
        button2.getStyleClass().add("przyciski_menu_powitalne");
        button2.setTranslateX(20);
        button2.setTranslateY(130);
        button2.setOnAction(event -> MenuController.onJoinButtonClick());

        // Tworzenie przycisku 3
        Button button3 = new Button("Powrot");
        button3.getStyleClass().add("przyciski_menu_powitalne");
        button3.setTranslateX(20);
        button3.setTranslateY(150);
        button3.setOnAction(event -> MenuController.onReturnToMultiOrSingleMenuButtonClick());

        // Tworzenie kontenera VBox i ustawianie przycisków na środku
        VBox buttonContainer = new VBox(10, button1, button2, button3);
        buttonContainer.setAlignment(Pos.CENTER);

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(MenuPowitalne, buttonContainer);

        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, MenuPowitlaneImage.getWidth(), MenuPowitlaneImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.resize(scene);
        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();
    }

    public static void showJoinMenu() {
        // Tworzenie obiektu MenuPowitlane
        ImageView MenuPowitalne = new ImageView();

        // Wczytywanie obrazu
        Image MenuPowitlaneImage = new Image("file:../../assets/MenuPowitalne.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        MenuPowitalne.setImage(MenuPowitlaneImage);
        MenuPowitalne.setFitWidth(ScreenSettings.screenWidth);
        MenuPowitalne.setFitHeight(ScreenSettings.screenHeight);

        TextField textField = new TextField();
        textField.setPromptText("Wprowadz tekst...");
        textField.setMaxWidth(400);
        textField.getStyleClass().add("text_field");
        textField.setTranslateX(20);
        textField.setTranslateY(110);

        // Tworzenie przycisku 2
        Button button2 = new Button("Dolacz");
        button2.getStyleClass().add("przyciski_menu_powitalne");
        button2.setTranslateX(20);
        button2.setTranslateY(130);
        button2.setOnAction(event -> MenuController.onJoinToSessionButtonClick(textField.getText()));

        // Tworzenie przycisku 3
        Button button3 = new Button("Powrot");
        button3.getStyleClass().add("przyciski_menu_powitalne");
        button3.setTranslateX(20);
        button3.setTranslateY(150);
        button3.setOnAction(event -> MenuController.onReturnToHostOrJoinMenuButtonClick());

        // Tworzenie kontenera VBox i ustawianie przycisków na środku
        VBox buttonContainer = new VBox(10, textField, button2, button3);
        buttonContainer.setAlignment(Pos.CENTER);

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(MenuPowitalne, buttonContainer);

        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, MenuPowitlaneImage.getWidth(), MenuPowitlaneImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.resize(scene);
        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();
    }

    public static void showQuantityMenu(GameType gameType) {
        ImageView Quantity = new ImageView();
        Image QuantityImage = new Image("file:../../assets/WyborIlosciGraczy.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        Quantity.setImage(QuantityImage);
        Quantity.setFitWidth(ScreenSettings.screenWidth);
        Quantity.setFitHeight(ScreenSettings.screenHeight);

        // Tworzenie przycisku 1
        Button button1 = new Button("Wyjscie");
        button1.getStyleClass().add("przyciski_menu_powitalne");
        button1.setTranslateX(0);
        button1.setTranslateY(300);
        button1.setOnAction(event -> MenuController.onReturnToMultiOrSingleMenuButtonClick());

        // Tworzenie przycisku 3
        Button button3 = new Button("");
        button3.getStyleClass().add("przyciski_niewidzialne");
        button3.setTranslateX(0);
        button3.setTranslateY(-340);
        button3.setOnAction(event -> MenuController.onQuantityButtonClick(gameType, 2));


        // Tworzenie przycisku 4
        Button button4 = new Button("");
        button4.getStyleClass().add("przyciski_niewidzialne");
        button4.setTranslateX(0);
        button4.setTranslateY(-120);
        button4.setOnAction(event -> MenuController.onQuantityButtonClick(gameType, 3));

        // Tworzenie przycisku 5
        Button button5 = new Button("");
        button5.getStyleClass().add("przyciski_niewidzialne");
        button5.setTranslateX(0);
        button5.setTranslateY(100);
        button5.setOnAction(event -> MenuController.onQuantityButtonClick(gameType, 4));

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(Quantity, button3, button4, button5, button1);


        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, QuantityImage.getWidth(), QuantityImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.resize(scene);
        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();

    }

    public static void showNickAndPawnMenu() {
        // Tworzenie obiektu MenuPowitlane
        ImageView MenuPowitalne = new ImageView();

        // Wczytywanie obrazu
        Image MenuPowitlaneImage = new Image("file:../../assets/MenuPowitalne.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        MenuPowitalne.setImage(MenuPowitlaneImage);
        MenuPowitalne.setFitWidth(ScreenSettings.screenWidth);
        MenuPowitalne.setFitHeight(ScreenSettings.screenHeight);

        //Podaj swój nick
        Button button5 = new Button("PODAJ SWOJ NICK");
        button5.getStyleClass().add("tekst");
        button5.setTranslateX(30);
        button5.setTranslateY(-80);

        //Okienko do wpisywania
        TextField textField = new TextField();
        textField.setPromptText("Twoj nick");
        textField.getStyleClass().add("text_field");
        textField.setMaxWidth(400);
        textField.setTranslateX(30);
        textField.setTranslateY(0);

        //Wybierz swój pionek
        Button button6 = new Button("WYBIERZ SWOJ PIONEK");
        button6.getStyleClass().add("tekst");
        button6.setTranslateX(30);
        button6.setTranslateY(140);

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(MenuPowitalne, textField, button5, button6);

        ArrayList<PawnColor> colors = Game.availableColors();

        if(colors.contains(PawnColor.blue)){
            //Pionek1
            ImageView Pionek1 = new ImageView();
            Image Pionek1Image = new Image("file:../../assets/PIONEK1.png");
            Pionek1.setImage(Pionek1Image);
            Pionek1.setTranslateY(284);
            Pionek1.setTranslateX(-220);

            //Przycisk do pionka 1

            Button button1 = new Button("");
            button1.getStyleClass().add("pionki");
            button1.setTranslateY(284);
            button1.setTranslateX(-220);
            button1.setOnAction(event -> MenuController.onPawnButtonClick(textField.getText(), PawnColor.blue));

            root.getChildren().addAll(Pionek1, button1);
        }


        if(colors.contains(PawnColor.yellow)) {
            //Pionek2
            ImageView Pionek2 = new ImageView();
            Image Pionek2Image = new Image("file:../../assets/PIONEK2.png");
            Pionek2.setImage(Pionek2Image);
            Pionek2.setTranslateY(284);
            Pionek2.setTranslateX(-50);

            //Przycisk do pionka 2

            Button button2 = new Button("");
            button2.getStyleClass().add("pionki");
            button2.setTranslateY(284);
            button2.setTranslateX(-50);
            button2.setOnAction(event -> MenuController.onPawnButtonClick(textField.getText(), PawnColor.yellow));

            root.getChildren().addAll(Pionek2, button2);
        }

        if(colors.contains(PawnColor.green)) {
            //Pionek3
            ImageView Pionek3 = new ImageView();
            Image Pionek3Image = new Image("file:../../assets/PIONEK3.png");
            Pionek3.setImage(Pionek3Image);
            Pionek3.setTranslateY(284);
            Pionek3.setTranslateX(120);

            //Przycisk do pionka 3

            Button button3 = new Button("");
            button3.getStyleClass().add("pionki");
            button3.setTranslateY(284);
            button3.setTranslateX(120);
            button3.setOnAction(event -> MenuController.onPawnButtonClick(textField.getText(), PawnColor.green));

            root.getChildren().addAll(Pionek3, button3);
        }

        if(colors.contains(PawnColor.red)) {
            //Pionek4
            ImageView Pionek4 = new ImageView();
            Image Pionek4Image = new Image("file:../../assets/PIONEK4.png");
            Pionek4.setImage(Pionek4Image);
            Pionek4.setTranslateY(284);
            Pionek4.setTranslateX(290);

            //Przycisk do pionka 4

            Button button4 = new Button("");
            button4.getStyleClass().add("pionki");
            button4.setTranslateY(284);
            button4.setTranslateX(290);
            button4.setOnAction(event -> MenuController.onPawnButtonClick(textField.getText(), PawnColor.red));

            root.getChildren().addAll(Pionek4, button4);
        }

        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, MenuPowitlaneImage.getWidth(), MenuPowitlaneImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.resize(scene);
        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();
    }
}
