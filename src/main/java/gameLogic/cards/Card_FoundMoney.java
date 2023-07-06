package gameLogic.cards;

import gameLogic.Player;

public class Card_FoundMoney implements Card
{
    private final static String name = "Card_FoundMoney";
    private final static boolean decisionNeeded = false;

    //
    @Override
    public void takeAction(Player player)
    {
        player.giveMoney(MONEY_FOUND_VALUE);
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
