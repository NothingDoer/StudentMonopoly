package gameLogic.cards;

import gameLogic.Game;
import gameLogic.GameInfo;
import gameLogic.Player;


public class Card_Birthday implements Card
{
    private final static String name = "Card_Birthday";
    private final static boolean decisionNeeded = false;

    // Wszyscy gracze idą na pole DARMOWA HERBATA W BIBLIOTECE
    // i każdy ze studentów daje po 20m$. Nie otrzymują pieniędzy za przejście przez start
    @Override
    public void takeAction(Player player)
    {
        int money = GameInfo.NONE;
        for(Player current : Game.getPlayers())
        {
            current.unconditionalMove(LIBRARY_TEA_SQUARE);
            if(current!=player)
                money += current.takeMoney(LIBRARY_TEA_SQUARE_VALUE);
        }
        player.giveMoney(money);
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
