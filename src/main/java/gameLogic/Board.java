package gameLogic;

import gameLogic.cards.Card;

import java.io.Serializable;

import java.util.ArrayList;

import static gameLogic.TypesOfSqueres.*;

public class Board implements Serializable {
    public static final int UNUPGRADABLE = -1;
    public static final int UPGRADE_PRICE_ROW_1 = 50;
    public static final int UPGRADE_PRICE_ROW_2 = 100;
    public static final int UPGRADE_PRICE_ROW_3 = 150;
    public static final int UPGRADE_PRICE_ROW_4 = 200;

    private final ArrayList<Square> squares = new ArrayList<>();
    private Card drawnCard = null;
    private final StackOfCards chance = new StackOfCards();
    private final StackOfCards studentCash = new StackOfCards();

    public Board() {
        initSquares();
        chance.initStackOfCardsChance();
        studentCash.initStackOfCardsStudentCash();
    }

    private void initSquares() {
        squares.add(new Square("START", START, 0));
        squares.add(new Property("INSTYTUT ZARZADZANIA", INSTITUTE, 60, UPGRADE_PRICE_ROW_1, 1, new int[]{2 ,10, 30, 90, 160, 250}));
        squares.add(new Square("KASA STUDENCKA", STUDENT_CASH, 0));
        squares.add(new Property("INSTYTUT MARKETINGU I ZROWNOWAZONEGO ROZWOJU", INSTITUTE, 60, UPGRADE_PRICE_ROW_1, 1, new int[]{4 ,20, 60, 180, 320, 450}));
        squares.add(new Square("LEGITYMACJA", STUDENT_CARD, 200));
        squares.add(new Property("PARKING KAMPUS A", PARKING, 200, UNUPGRADABLE, UNUPGRADABLE, new int[]{25, 50, 100, 200}));
        squares.add(new Property("KATEDRA POJAZDOW I PODSTAW BUDOWY MASZYN", INSTITUTE, 100, UPGRADE_PRICE_ROW_1, 2, new int[]{6, 30, 90, 270, 400, 550}));
        squares.add(new Square("SZANSA", CHANCE, 0));
        squares.add(new Property("INSTYTUT INZYNIERII MATERIALOWEJ", INSTITUTE, 100, UPGRADE_PRICE_ROW_1, 2, new int[]{6, 30, 90, 270, 400, 550}));
        squares.add(new Property("KATEDRA DYNAMIKI MASZYN", INSTITUTE, 120, UPGRADE_PRICE_ROW_1, 2, new int[]{8, 40, 100, 300, 450, 600}));
        squares.add(new Square("DANTE", DANTE, 0));
        squares.add(new Property("INSTYTUT TECHNOLOGII POLIMEROW I BARWNIKOW", INSTITUTE, 140, UPGRADE_PRICE_ROW_2, 3, new int[]{10, 50, 150, 450, 625, 750}));
        squares.add(new Property("ZATOKA SPORTU", SPORT_VENUE, 150, UNUPGRADABLE, UNUPGRADABLE, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("INSTYTUT CHEMII OGOLNEJ I EKOLOGICZNEJ", INSTITUTE, 140, UPGRADE_PRICE_ROW_2, 3, new int[]{10, 50, 150, 450, 625, 750}));
        squares.add(new Property("MIEDZYRESORTOWY INSTYTUT TECHNIKI RADIACYJNEJ", INSTITUTE, 160, UPGRADE_PRICE_ROW_2, 3, new int[]{12, 60, 180, 500, 700, 900}));
        squares.add(new Property("PARKING KAMPUS B", PARKING, 200, UNUPGRADABLE, UNUPGRADABLE, new int[]{25, 50, 100, 200}));
        squares.add(new Property("INSTYTUT MATERIALOZNAWSTWA TEKSTYLIOW I KOMPOZYTOW POLIMEROWYCH", INSTITUTE, 180, UPGRADE_PRICE_ROW_2, 4, new int[]{14, 70, 200, 550, 750, 950}));
        squares.add(new Square("KASA STUDENCKA", STUDENT_CASH, 0));
        squares.add(new Property("INSTYTUT ARCHITEKTURY TEKSTYLIOW", INSTITUTE, 180, UPGRADE_PRICE_ROW_2, 4, new int[]{14, 70, 200, 550, 750, 950}));
        squares.add(new Property("KATEDRA TECHNOLOGII DZIEWIARSKICH I MASZYN WLOKIENNICZYCH", INSTITUTE, 200, UPGRADE_PRICE_ROW_2, 4, new int[]{16, 80, 220, 600, 800, 1000}));
        squares.add(new Square("BIBLIOTEKA", LIBRARY, 0));
        squares.add(new Property("INSTYTUT ARCHITEKTURY I URBANISTYKI", INSTITUTE, 220, UPGRADE_PRICE_ROW_3, 5, new int[]{18, 90, 250, 700, 875, 1050}));
        squares.add(new Square("SZANSA", CHANCE, 0));
        squares.add(new Property("KATEDRA BUDOWNICTWA BETONOWEGO", INSTITUTE, 220, UPGRADE_PRICE_ROW_3, 5, new int[]{18, 90, 250, 700, 875, 1050}));
        squares.add(new Property("KATEDRA MECHANIKI KONSTRUKCJI", INSTITUTE, 240, UPGRADE_PRICE_ROW_3, 5, new int[]{20, 100, 300, 750, 925, 1100}));
        squares.add(new Property("PARKING KAMPUS C", PARKING, 200, UNUPGRADABLE, UNUPGRADABLE, new int[]{25, 50, 100, 200}));
        squares.add(new Property("KATEDRA INZYNIERII BIOPROCESOWEJ", INSTITUTE, 260, UPGRADE_PRICE_ROW_3, 6, new int[]{22, 110, 330, 800, 975, 1150}));
        squares.add(new Property("KATEDRA INZYNIERII BEZPIECZENSTWA PRACY", INSTITUTE, 260, UPGRADE_PRICE_ROW_3, 6, new int[]{22, 110, 330, 800, 975, 1150}));
        squares.add(new Property("CANTRUM SPORTU", SPORT_VENUE, 150, UNUPGRADABLE, UNUPGRADABLE, new int[]{0 ,0 ,0 ,0}));
        squares.add(new Property("KATEDRA INZYNIERII MOLEKULARNEJ", INSTITUTE, 280, UPGRADE_PRICE_ROW_3, 6, new int[]{24, 120, 360, 850, 1025, 1200}));
        squares.add(new Square("PORA NA DANTE", DANTE_AGAIN, 0));
        squares.add(new Property("INSTYTUT FIZYKI", INSTITUTE, 300, UPGRADE_PRICE_ROW_4, 7, new int[]{26, 130, 390, 900, 1100, 1275}));
        squares.add(new Property("INSTYTUT INFORMATYKI", INSTITUTE, 300, UPGRADE_PRICE_ROW_4, 7, new int[]{26, 130, 390, 900, 1100, 1275}));
        squares.add(new Square("KASA STUDENCKA", STUDENT_CASH, 0));
        squares.add(new Property("INSTYTUT MATEMATYKI", INSTITUTE, 320, UPGRADE_PRICE_ROW_4, 7, new int[]{28, 150, 450, 1000, 1200, 1400}));
        squares.add(new Property("PARKING REKTORA", PARKING, 200, UNUPGRADABLE, UNUPGRADABLE, new int[]{25, 50, 100, 200}));
        squares.add(new Square("SZANSA", CHANCE, 0));
        squares.add(new Property("INSTYTUT MECHATRONIKI SYSTEMOW INFORMATYCZNYCH", INSTITUTE, 350, UPGRADE_PRICE_ROW_4, 8, new int[]{35, 175, 500, 1100, 1300, 1500}));
        squares.add(new Square("WARUNEK", FAILED_SUBIECT_FEE, 100));
        squares.add(new Property("KATEDRA MIKROELEKTRONIKI I TECHNIK INFORMATYCZNYCH", INSTITUTE, 400, UPGRADE_PRICE_ROW_4, 8, new int[]{50, 200, 600, 1400, 1700, 2000}));
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public Card getDrawnCard() {
        return drawnCard;
    }

    public void setDrawnCard(Card drawedCard) {
        this.drawnCard = drawedCard;
    }

    public StackOfCards getChance() {
        return chance;
    }

    public StackOfCards getStudentCash() {
        return studentCash;
    }
}
