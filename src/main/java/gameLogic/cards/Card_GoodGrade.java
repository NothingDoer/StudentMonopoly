package gameLogic.cards;

import gameLogic.DecisionType;
import gameLogic.Player;

public class Card_GoodGrade implements Card
{
    private final static String name = "Card_GoodGrade";
    private final static boolean decisionNeeded = true;

    // karta przesuwa gracza o dowolna wartosc od -3 do 3
    @Override
    public void takeAction(Player player)
    {
        player.makeDecision(DecisionType.CardGoodGrade);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isDecisionNeeded() {
        return decisionNeeded;
    }
}
