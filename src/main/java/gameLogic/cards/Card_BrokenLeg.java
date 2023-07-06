package gameLogic.cards;

import gameLogic.Player;

public class Card_BrokenLeg implements Card
{
    private final static String name = "Card_BrokenLeg";
    private final static boolean decisionNeeded = false;

    // Gracz podczas kolejnego ruchu rzuca tylko jedna koscia
    @Override
    public void takeAction(Player player)
    {
        player.setHowManyDicesToThrow(ONE_DICE);
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
