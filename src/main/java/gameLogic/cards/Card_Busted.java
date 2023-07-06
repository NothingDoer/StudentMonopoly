package gameLogic.cards;

import gameLogic.DecisionType;
import gameLogic.Player;

public class Card_Busted implements Card
{
    private final static String name = "Card_Busted";
    private final static boolean decisionNeeded = true;

    // Gracz ktory dobral te karte moze wyslac innego gracza do dante (wiezienia) na jedna kolejke
    @Override
    public void takeAction(Player player)
    {
        player.makeDecision(DecisionType.CardBusted);
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
