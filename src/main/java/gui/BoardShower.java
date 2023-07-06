package gui;

import gameLogic.Game;
import gameLogic.Property;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class BoardShower {
    private static StackPane board = new StackPane();
    private static BoardMode mode = BoardMode.Info;

    public static void showBoard() {
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(board);
        board = new StackPane();
        board.setAlignment(Pos.TOP_LEFT);
        board.setPrefWidth(902);
        board.setPrefHeight(902);
        board.setTranslateX(848);
        board.setTranslateY(50);

        ImageView Board = new ImageView();
        Image BoardImage = new Image("file:../../assets/Studenckibiznes.png");
        Board.setImage(BoardImage);
        Board.setFitHeight(702);
        Board.setFitWidth(702);
        Board.setTranslateY(100);
        Board.setTranslateX(100);

        //START

        ImageView Start = new ImageView();
        Image StartImage = new Image("file:../../assets/START.png");
        Start.setImage(StartImage);
        Start.setTranslateY(802);
        Start.setTranslateX(802);

        //WEEIA2

        ImageView Weeia2 = new ImageView();
        Image Weeia2Image = new Image("file:../../assets/WEEIA2.png");
        Weeia2.setImage(Weeia2Image);
        Weeia2.setTranslateY(724);
        Weeia2.setTranslateX(802);
        Weeia2.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(39)));

        //WOiZ1

        ImageView Woiz1 = new ImageView();
        Image Woiz1Image = new Image("file:../../assets/WOiZ1.png");
        Woiz1.setImage(Woiz1Image);
        Woiz1.setTranslateY(802);
        Woiz1.setTranslateX(724);
        Woiz1.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(1)));

        //Kasa studencka 1

        ImageView Kasastudencka1 = new ImageView();
        Image Kasastudencka1Image = new Image("file:../../assets/KASASTUDENCKA1.png");
        Kasastudencka1.setImage(Kasastudencka1Image);
        Kasastudencka1.setTranslateY(802);
        Kasastudencka1.setTranslateX(646);

        //WOiZ2

        ImageView Woiz2 = new ImageView();
        Image Woiz2Image = new Image("file:../../assets/WOiZ1.png");
        Woiz2.setImage(Woiz2Image);
        Woiz2.setTranslateY(802);
        Woiz2.setTranslateX(568);
        Woiz2.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(3)));

        //Legitymacja

        ImageView Legitymacja = new ImageView();
        Image LegitymacjaImage = new Image("file:../../assets/LEGITYMACJA.png");
        Legitymacja.setImage(LegitymacjaImage);
        Legitymacja.setTranslateY(802);
        Legitymacja.setTranslateX(490);

        //ParkingA

        ImageView ParkingA = new ImageView();
        Image ParkingAImage = new Image("file:../../assets/PARKINGA.png");
        ParkingA.setImage(ParkingAImage);
        ParkingA.setTranslateY(802);
        ParkingA.setTranslateX(412);
        ParkingA.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(5)));

        //WM1

        ImageView Wm1 = new ImageView();
        Image Wm1Image = new Image("file:../../assets/WM1.png");
        Wm1.setImage(Wm1Image);
        Wm1.setTranslateY(802);
        Wm1.setTranslateX(334);
        Wm1.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(6)));

        //Szansa 1

        ImageView Szansa1 = new ImageView();
        Image Szansa1Image = new Image("file:../../assets/SZANSA1.png");
        Szansa1.setImage(Szansa1Image);
        Szansa1.setTranslateY(802);
        Szansa1.setTranslateX(256);

        //WM2

        ImageView Wm2 = new ImageView();
        Image Wm2Image = new Image("file:../../assets/WM1.png");
        Wm2.setImage(Wm2Image);
        Wm2.setTranslateY(802);
        Wm2.setTranslateX(178);
        Wm2.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(8)));

        //WM3

        ImageView Wm3 = new ImageView();
        Image Wm3Image = new Image("file:../../assets/WM3.png");
        Wm3.setImage(Wm3Image);
        Wm3.setTranslateY(802);
        Wm3.setTranslateX(100);
        Wm3.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(9)));

        //Wiezienie

        ImageView Wiezienie = new ImageView();
        Image WiezienieImage = new Image("file:../../assets/WIEZIENIE.png");
        Wiezienie.setImage(WiezienieImage);
        Wiezienie.setTranslateY(802);
        Wiezienie.setTranslateX(0);

        //WCH1

        ImageView Wch1 = new ImageView();
        Image Wch1Image = new Image("file:../../assets/WCH1.png");
        Wch1.setImage(Wch1Image);
        Wch1.setTranslateY(724);
        Wch1.setTranslateX(0);
        Wch1.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(11)));

        //Zatoka Sportu

        ImageView ZatokaSportu = new ImageView();
        Image ZatokaSportuImage = new Image("file:../../assets/ZATOKASPORTU.png");
        ZatokaSportu.setImage(ZatokaSportuImage);
        ZatokaSportu.setTranslateY(646);
        ZatokaSportu.setTranslateX(0);
        ZatokaSportu.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(12)));

        //WCH2

        ImageView Wch2 = new ImageView();
        Image Wch2Image = new Image("file:../../assets/WCH1.png");
        Wch2.setImage(Wch2Image);
        Wch2.setTranslateY(568);
        Wch2.setTranslateX(0);
        Wch2.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(13)));


        //WCH3

        ImageView Wch3 = new ImageView();
        Image Wch3Image = new Image("file:../../assets/WCH3.png");
        Wch3.setImage(Wch3Image);
        Wch3.setTranslateY(490);
        Wch3.setTranslateX(0);
        Wch3.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(14)));

        //Parking B

        ImageView ParkingB = new ImageView();
        Image ParkingBImage = new Image("file:../../assets/PARKINGB.png");
        ParkingB.setImage(ParkingBImage);
        ParkingB.setTranslateY(412);
        ParkingB.setTranslateX(0);
        ParkingB.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(15)));

        //WTMiWT1

        ImageView Wtmiwt1 = new ImageView();
        Image Wtmiwt1Image = new Image("file:../../assets/WTMiWT1.png");
        Wtmiwt1.setImage(Wtmiwt1Image);
        Wtmiwt1.setTranslateY(334);
        Wtmiwt1.setTranslateX(0);
        Wtmiwt1.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(16)));

        //Kasa studencka 2

        ImageView Kasastudencka2 = new ImageView();
        Image Kasastudencka2Image = new Image("file:../../assets/KASASTUDENCKA2.png");
        Kasastudencka2.setImage(Kasastudencka2Image);
        Kasastudencka2.setTranslateY(256);
        Kasastudencka2.setTranslateX(0);

        //WTMiWT2

        ImageView Wtmiwt2 = new ImageView();
        Image Wtmiwt2Image = new Image("file:../../assets/WTMiWT1.png");
        Wtmiwt2.setImage(Wtmiwt2Image);
        Wtmiwt2.setTranslateY(178);
        Wtmiwt2.setTranslateX(0);
        Wtmiwt2.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(18)));

        //WTMiWT3

        ImageView Wtmiwt3 = new ImageView();
        Image Wtmiwt3Image = new Image("file:../../assets/WTMiWT3.png");
        Wtmiwt3.setImage(Wtmiwt3Image);
        Wtmiwt3.setTranslateY(100);
        Wtmiwt3.setTranslateX(0);
        Wtmiwt3.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(19)));

        //Biblioteka

        ImageView Biblioteka = new ImageView();
        Image BibliotekaImage = new Image("file:../../assets/BIBLIOTEKA.png");
        Biblioteka.setImage(BibliotekaImage);
        Biblioteka.setTranslateY(0);
        Biblioteka.setTranslateX(0);
        Biblioteka.setRotate(90);


        //BAiS 1

        ImageView Bais1 = new ImageView();
        Image Bais1Image = new Image("file:../../assets/BAiŚ1.png");
        Bais1.setImage(Bais1Image);
        Bais1.setTranslateY(0);
        Bais1.setTranslateX(100);
        Bais1.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(21)));

        //Szansa 2

        ImageView Szansa2 = new ImageView();
        Image Szansa2Image = new Image("file:../../assets/SZANSA2.png");
        Szansa2.setImage(Szansa2Image);
        Szansa2.setTranslateY(0);
        Szansa2.setTranslateX(178);


        //BAiS 2

        ImageView Bais2 = new ImageView();
        Image Bais2Image = new Image("file:../../assets/BAiŚ1.png");
        Bais2.setImage(Bais2Image);
        Bais2.setTranslateY(0);
        Bais2.setTranslateX(256);
        Bais2.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(23)));

        //BAiS 3

        ImageView Bais3 = new ImageView();
        Image Bais3Image = new Image("file:../../assets/BAiŚ3.png");
        Bais3.setImage(Bais3Image);
        Bais3.setTranslateY(0);
        Bais3.setTranslateX(334);
        Bais3.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(24)));


        //Parking C

        ImageView ParkingC = new ImageView();
        Image ParkingCImage = new Image("file:../../assets/PARKINGC.png");
        ParkingC.setImage(ParkingCImage);
        ParkingC.setTranslateY(0);
        ParkingC.setTranslateX(412);
        ParkingC.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(25)));

        //IPiOS 1

        ImageView Ipios1 = new ImageView();
        Image Ipios1Image = new Image("file:../../assets/IPiOS1.png");
        Ipios1.setImage(Ipios1Image);
        Ipios1.setTranslateY(0);
        Ipios1.setTranslateX(490);
        Ipios1.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(26)));

        //IPiOS 2

        ImageView Ipios2 = new ImageView();
        Image Ipios2Image = new Image("file:../../assets/IPiOS1.png");
        Ipios2.setImage(Ipios2Image);
        Ipios2.setTranslateY(0);
        Ipios2.setTranslateX(568);
        Ipios2.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(27)));

        //Centrum Sportu

        ImageView CentrumSportu = new ImageView();
        Image CentrumSportuImage = new Image("file:../../assets/CENTRUMSPORTU.png");
        CentrumSportu.setImage(CentrumSportuImage);
        CentrumSportu.setTranslateY(0);
        CentrumSportu.setTranslateX(646);
        CentrumSportu.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(28)));

        //IPiOS 3

        ImageView Ipios3 = new ImageView();
        Image Ipios3Image = new Image("file:../../assets/IPiOS3.png");
        Ipios3.setImage(Ipios3Image);
        Ipios3.setTranslateY(0);
        Ipios3.setTranslateX(724);
        Ipios3.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(29)));

        //Pora na Dante

        ImageView PoraNaDante = new ImageView();
        Image PoraNaDanteImage = new Image("file:../../assets/PORANADANTE.png");
        PoraNaDante.setImage(PoraNaDanteImage);
        PoraNaDante.setTranslateY(0);
        PoraNaDante.setTranslateX(802);
        PoraNaDante.setRotate(180);


        //Warunek

        ImageView Warunek = new ImageView();
        Image WarunekImage = new Image("file:../../assets/WARUNEK.png");
        Warunek.setImage(WarunekImage);
        Warunek.setTranslateY(646);
        Warunek.setTranslateX(802);

        //WEEIA1

        ImageView Weeia1 = new ImageView();
        Image Weeia1Image = new Image("file:../../assets/WEEIA1.png");
        Weeia1.setImage(Weeia1Image);
        Weeia1.setTranslateY(568);
        Weeia1.setTranslateX(802);
        Weeia1.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(37)));

        //Szansa 3

        ImageView Szansa3 = new ImageView();
        Image Szansa3Image = new Image("file:../../assets/SZANSA3.png");
        Szansa3.setImage(Szansa3Image);
        Szansa3.setTranslateY(490);
        Szansa3.setTranslateX(802);

        //Parking Rektora

        ImageView ParkingRektora = new ImageView();
        Image ParkingRektoraImage = new Image("file:../../assets/PARKINGREKTORA.png");
        ParkingRektora.setImage(ParkingRektoraImage);
        ParkingRektora.setTranslateY(412);
        ParkingRektora.setTranslateX(802);
        ParkingRektora.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(35)));

        //FTIMS 3

        ImageView Ftims3 = new ImageView();
        Image Ftims3Image = new Image("file:../../assets/FTIMS3.png");
        Ftims3.setImage(Ftims3Image);
        Ftims3.setTranslateY(334);
        Ftims3.setTranslateX(802);
        Ftims3.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(34)));

        //Kasa studencka 3

        ImageView Kasastudencka3 = new ImageView();
        Image Kasastudencka3Image = new Image("file:../../assets/KASASTUDENCKA3.png");
        Kasastudencka3.setImage(Kasastudencka3Image);
        Kasastudencka3.setTranslateY(256);
        Kasastudencka3.setTranslateX(802);

        //FTIMS 2

        ImageView Ftims2 = new ImageView();
        Image Ftims2Image = new Image("file:../../assets/FTIMS1.png");
        Ftims2.setImage(Ftims2Image);
        Ftims2.setTranslateY(178);
        Ftims2.setTranslateX(802);
        Ftims2.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(32)));

        //FTIMS 1

        ImageView Ftims1 = new ImageView();
        Image Ftims1Image = new Image("file:../../assets/FTIMS1.png");
        Ftims1.setImage(Ftims1Image);
        Ftims1.setTranslateY(100);
        Ftims1.setTranslateX(802);
        Ftims1.setOnMouseClicked(event -> onSquareClick((Property) Game.getBoard().getSquares().get(31)));

        board.getChildren().addAll(Board, Start, Weeia2, Woiz1, Kasastudencka1, Woiz2, Legitymacja, ParkingA,
                Wm1, Wm2, Szansa1, Wm3, Wiezienie, Wch1, Wch2, ZatokaSportu, Wch3, ParkingB, Wtmiwt1, Wtmiwt2, Kasastudencka2,
                Wtmiwt3, Biblioteka, Bais1, Bais2, Szansa2, ParkingC, Bais3, Ipios1, Ipios2, Ipios3, CentrumSportu, PoraNaDante,
                Warunek, Weeia1, Szansa3, ParkingRektora, Ftims3, Kasastudencka3, Ftims1, Ftims2);

        stackPane.getChildren().add(board);
    }

    public static void onSquareClick(Property property) {
        switch (mode) {
            case Info -> PropertyInfoBox.showPropertyInfo(property);
            case Upgrade -> {
                Game.conditionalActivePlayerBuyOrUpgrade(property);
                PropertyIconsShower.showPropertyIcons();
                PlayersInfoShower.showPlayersInfo();
            }
            case Sell -> {
                Game.conditionalActivePlayerSellOrDegrade(property);
                PropertyIconsShower.showPropertyIcons();
                PlayersInfoShower.showPlayersInfo();
            }
        }
    }

    public static void setMode(BoardMode mode) {
        BoardShower.mode = mode;
    }
}
