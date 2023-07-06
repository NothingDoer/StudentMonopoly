package gameLogic;

import java.io.Serializable;

public class Property extends Square implements Serializable {
    public static final int MAX_UPGRADE = 5;

    private final int price;
    private final int upgradePrice;
    private Player owner;
    private boolean mortgaged;
    private int upgrades;
    private final int[] stopPrices;
    private final int faculty;
    public int getFaculty() {
        return faculty;
    }

    public int mortgagePrice() {
        return (int) (0.5 * price);
    }

    public int getUpgrades() {
        return upgrades;
    }

    public int upgrade() {
        if(upgrades < MAX_UPGRADE){
            upgrades++;
            calculateNewFee();
        }
        return upgradePrice;
    }

    public int getUpgradePrice() {
        return upgradePrice;
    }

    public Player getOwner() {
        return owner;
    }

    public Property(String name, TypesOfSqueres type, int price, int upgradePrice, int faculty, int[] stopPrices) {
        super(name, type, 0);
        this.price = price;
        this.upgradePrice = upgradePrice;
        owner = null;
        upgrades = 0;
        mortgaged = false;
        this.faculty = faculty;
        this.stopPrices = stopPrices;
    }

    private void calculateNewFee() {
        if (mortgaged) {
            fee = 0;
        } else if (owner == null) {
            fee = 0;
        } else if (upgrades == 0) {
            fee = (int) (0.1 * price);
        } else {
            fee = upgrades * price;
        }

    }

    public int valueOfProperty() {
        return (upgradePrice * upgrades + price) / 2;
    }

    public void cleanProperty() {
        fee = 0;
        owner = null;
        upgrades = 0;
        mortgaged = false;
    }

    public int sellProperty() {
        int value = valueOfProperty();
        cleanProperty();
        return value;
    }

    public boolean hasAuditorium() {
        return upgrades == MAX_UPGRADE;
    }

    public void destroyAuditorium() {
        if (upgrades == MAX_UPGRADE) {
            upgrades = 4;
        }
    }

    public int[] getStopPrices() {
        return stopPrices;
    }

    public int getPrice() {
        return price;
    }

    public void buy(Player activePlayer) {
        if (activePlayer.getMoneyAmount() >= price) {
            activePlayer.takeMoney(price);
            owner = activePlayer;
        }
    }

    public boolean canBeUpgraded() {
        if(getType() != TypesOfSqueres.INSTITUTE){
            return false;
        }
        for (Square square : Game.getBoard().getSquares()) {
            if (square instanceof Property property && property.getFaculty() == this.getFaculty() && property.getType() == TypesOfSqueres.INSTITUTE) {
                if (property.getOwner() != this.getOwner() || property.getUpgrades() - this.getUpgrades() < 0) {
                    return false;
                }
            }
        }
        return upgrades < MAX_UPGRADE;
    }

    public boolean canBeDegraded() {
        if(getType() != TypesOfSqueres.INSTITUTE){
            return false;
        }
        for (Square square : Game.getBoard().getSquares()) {
            if (square instanceof Property property && property.getFaculty() == this.getFaculty() && property.getType() == TypesOfSqueres.INSTITUTE) {
                if (property.getOwner() != this.getOwner() || property.getUpgrades() - this.getUpgrades() > 0) {
                    return false;
                }
            }
        }
        return upgrades > 0;
    }

    public int degrade() {
        if(upgrades > 0){
            upgrades--;
            calculateNewFee();
        }
        return upgradePrice / 2;
    }

    public boolean canBeSell() {
        if(getType() != TypesOfSqueres.INSTITUTE){
            return true;
        }
        for (Square square : Game.getBoard().getSquares()) {
            if (square instanceof Property property && property.getFaculty() == this.getFaculty() && property.getType() == TypesOfSqueres.INSTITUTE) {
                if (property.getUpgrades() > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getStopPrice() {
        return switch(type){
            case INSTITUTE -> getInstituteStopPrice();
            case PARKING -> getParkingStopPrice();
            case SPORT_VENUE -> getSportVenueStopPrice();
            default -> 0;
        };
    }

    private int getSportVenueStopPrice() {
        var board = Game.getBoard().getSquares();
        if(((Property)board.get(GameInfo.FIRST_SPORT_VENUE_INDEX)).getOwner() == ((Property)board.get(GameInfo.SECOND_SPORT_VENUE_INDEX)).getOwner()){
            return 10 * Game.getActivePlayer().getDicesSum();
        }
        return 4 * Game.getActivePlayer().getDicesSum();
    }

    private int getParkingStopPrice() {
        int output = 0;
        for(int i = 5; i < 40; i += 10){
            Property parking = (Property) Game.getBoard().getSquares().get(i);
            if(parking != this && parking.getOwner() == owner){
                output++;
            }
        }
        return stopPrices[output];
    }

    private int getInstituteStopPrice() {
        return stopPrices[upgrades];
    }
}
