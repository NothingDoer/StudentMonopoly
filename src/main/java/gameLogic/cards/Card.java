package gameLogic.cards;

import gameLogic.Player;

import java.io.Serializable;

public interface Card extends Serializable
{
    int DANTE_ROUNDS = 2;
    int SCHOLARSHIP_VALUE = 200;
    int CONDITION_VALUE = 50;
    int LIBRARY_TEA_SQUARE = 20;
    int LIBRARY_TEA_SQUARE_VALUE = 20;
    int CROSSING_RED_LIGHT_VALUE = 100;
    int ONLINE_SITE_VALUE = 20;
    int DANTE_RELIEF = -1;
    int MONEY_FOUND_VALUE = 10;
    int ONE_DICE = 1;
    void takeAction(Player player);
    String getName();

    boolean isDecisionNeeded();
}
