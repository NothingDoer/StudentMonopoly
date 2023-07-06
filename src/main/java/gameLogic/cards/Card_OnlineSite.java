package gameLogic.cards;

import gameLogic.Player;

public class Card_OnlineSite implements Card
{
    private final static String name = "Card_OnlineSite";
    private final static boolean decisionNeeded = false;

    // Daje graczowi gotowke
    @Override
    public void takeAction(Player player)
    {
        player.giveMoney(ONLINE_SITE_VALUE);
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
