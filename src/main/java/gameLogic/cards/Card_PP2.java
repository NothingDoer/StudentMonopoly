package gameLogic.cards;

import gameLogic.GameInfo;
import gameLogic.Player;

public class Card_PP2 implements Card
{
    private final static String name = "Card_PP2";
    private final static boolean decisionNeeded = false;

    // Karta wysyla gracza na robienie dante (wiezienie) na 2 tury
    @Override
    public void takeAction(Player player)
    {
        player.changeDanteDuration(DANTE_ROUNDS);
        player.unconditionalMove(GameInfo.DANTE_SQUARE_INDEX);
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
