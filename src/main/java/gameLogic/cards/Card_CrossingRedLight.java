package gameLogic.cards;

import gameLogic.Player;

public class Card_CrossingRedLight implements Card
{
    private final static String name = "Card_CrossingRedLight";
    private final static boolean decisionNeeded = false;

    // karta zabiera graczowi 100 pe-elenów
    @Override
    public void takeAction(Player player)
    {
        player.takeMoney(CROSSING_RED_LIGHT_VALUE);
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
