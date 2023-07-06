package gameLogic.cards;

import gameLogic.Player;
import gameLogic.Property;

public class Card_Busy implements Card
{
    private final static String name = "Card_Busy";
    private final static boolean decisionNeeded = false;

    // karta ma niszczyc aule gracza
    @Override
    public void takeAction(Player player)
    {
        for(Property property : player.ownedProperties())
            if(property.hasAuditorium())
            {
                property.destroyAuditorium();
                break;
            }
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
