package gameLogic.cards;

import gameLogic.Player;

public class Card_ElectricDeficiency implements Card
{
    private final static String name = "Card_ElectricDeficiency";
    private final static boolean decisionNeeded = false;

    // Karta sprawia, ze przez jedna kolejke gracz nie pobiera oplat za swoje pola
    @Override
    public void takeAction(Player player)
    {
        player.setElectricDeficiencyStatus(true);
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
