package gameLogic.cards;

import gameLogic.Player;

public class Card_Erasmus implements Card
{
    private final static String name = "Card_Erasmus";
    private final static boolean decisionNeeded = false;

    // Gracz dzieki tej fladze nie bedzie musial placic innym graczom podczas pobytu na ich polu
    @Override
    public void takeAction(Player player)
    {
        player.setOnErasmus(2);
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
