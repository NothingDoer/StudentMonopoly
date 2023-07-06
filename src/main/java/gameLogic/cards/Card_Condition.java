package gameLogic.cards;

import gameLogic.Player;

public class Card_Condition implements Card
{
    private final static String name = "Card_Condition";
    private final static boolean decisionNeeded = false;

    // Zabiera graczowi gotowke
    @Override
    public void takeAction(Player player)
    {
        player.takeMoney(CONDITION_VALUE);
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
