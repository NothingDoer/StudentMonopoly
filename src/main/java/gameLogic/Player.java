package gameLogic;

import gui.DecisionButtonsShower;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Player implements Serializable {
    private final Pawn pawn;
    private int moneyAmount = GameInfo.START_VALUE;
    private int inDante = 0;
    private boolean isBankrupt = false;
    private boolean hasCardChance = false;
    private int onErasmus = 0;
    private boolean hasElectricDeficiency = false;
    private ArrayList<Integer> lastDices;
    private ArrayList<Integer> dices;
    private boolean doubleLastMove = false;
    private int numberOfDoublets = 0;
    private static final Random randomGenerator = new Random();
    private final String nick;

    public Player(String nick, PawnColor color) {
        if (nick == null || nick.equals("")) {
            nick = generateNick();
        }
        this.nick = nick;
        pawn = new Pawn(color);
        dices = new ArrayList<>();
        for (int i = 0; i < GameInfo.INITIAL_NUMBER_OF_DICES; i++) {
            dices.add(0);
        }
    }

    public String generateNick() {
        String tempNick = "Student ";
        int random = randomGenerator.nextInt(90) + 10;
        tempNick += random;
        return tempNick;
    }

    public String getNick() {
        return nick;
    }

    public int valueOfProperties(ArrayList<Property> properties) {
        int suma = GameInfo.NONE;
        for (Property temp : properties)
            suma += temp.valueOfProperty();

        return suma;
    }

    public ArrayList<Property> ownedProperties() {
        ArrayList<Property> tempList = new ArrayList<>();
        for (Square square : Game.getBoard().getSquares())
            if (square instanceof Property temp && temp.getOwner() == this)
                tempList.add(temp);

        return tempList;
    }

    public int takeMoney(int amount) {
        moneyAmount -= amount;

        if(moneyAmount < 0){
            moneyAmount = 0;
        }

        return amount;
    }

    public ArrayList<Integer> rollDices() {
        dices.replaceAll(ignored -> randomGenerator.nextInt(6) + 1);
        if (checkDoubles()) {
            numberOfDoublets++;
            if (checkTooMuchDoubles()) {
                makeDecision(DecisionType.GoToDante);
                goToDante();
            }
        }
        lastDices = new ArrayList<>(dices);
        setHowManyDicesToThrow(GameInfo.INITIAL_NUMBER_OF_DICES);
        return lastDices;
    }

    private boolean checkDoubles() {
        if(dices.size() < 2) {
            return false;
        }

        for (int i = 1; i < dices.size(); i++) {
            if (!Objects.equals(dices.get(i), dices.get(i - 1))) {
                doubleLastMove = false;
                return false;
            }
        }
        doubleLastMove = true;
        return true;
    }

    private boolean checkTooMuchDoubles() {
        return numberOfDoublets >= 3;
    }

    private void goToDante() {
        inDante = 3;
        unconditionalMove(GameInfo.DANTE_SQUARE_INDEX);
    }

    public void unconditionalMove(int squareNumber) {
        pawn.getToSquare(squareNumber);
    }

    public void conditionalMove(ArrayList<Integer> moves) {
        int shift = 0;
        for (int dice : moves) {
            shift += dice;
        }

        int startPosition = pawn.getPosition();
        pawn.move(shift);
        if (startPosition > pawn.getPosition()) {
            giveMoney(GameInfo.START_SQUARE_ADDITION);
        }
    }

    public void conditionalMove(int moves) {
        int startPosition = pawn.getPosition();
        pawn.move(moves);
        if (startPosition > pawn.getPosition()) {
            giveMoney(GameInfo.START_SQUARE_ADDITION);
        }
    }

    public boolean checkIfCanTakeMoneyWithoutBankrupt(int amount) {
        return valueOfProperties(ownedProperties()) + getMoneyAmount() >= amount; // True jezeli mozna zabrac gotowke bez bankructwa
    }

    public void makeDecision(DecisionType type) {
        switch (type) {
            case RoundStart -> {
                if (inDante > 0) {
                    DecisionButtonsShower.showInDanteDecisionButtons(hasCardChance);
                } else {
                    DecisionButtonsShower.showRoundStartDecisionButtons();
                }
            }
            case DrawCard -> DecisionButtonsShower.showDrawCardDecisionButtons();
            case Buy -> DecisionButtonsShower.showBuyDecisionButtons();
            case PayForStop -> {
                Property property = (Property) Game.getBoard().getSquares().get(Game.getActivePlayer().getPawn().getPosition());
                DecisionButtonsShower.showPayDecisionButtons(Game.getActivePlayer(), property.getOwner(), property.getStopPrice());
            }
            case PayToBank -> {
                Square square = Game.getBoard().getSquares().get(Game.getActivePlayer().getPawn().getPosition());
                DecisionButtonsShower.showPayDecisionButtons(Game.getActivePlayer(), null, square.getFee());
            }
            case GoToDante -> DecisionButtonsShower.showGoToDanteDecisionButtons();
            case EndRound -> DecisionButtonsShower.showEndRoundDecisionButtons();
            case Bankrupt -> DecisionButtonsShower.showBankruptDecisionButtons();
            case Win -> DecisionButtonsShower.showWinDecisionButtons();
            case CardBusted -> DecisionButtonsShower.showCardBustedDecisionButtons();
            case CardGoodGrade -> DecisionButtonsShower.showCardGoodGradeDecisionButtons();
            default -> Game.conditionalNextRound();
        }
    }

    public int getInDante() {
        return inDante;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void changeDanteDuration(int numberOfRounds) {
        inDante += numberOfRounds;
    }
    public void setDanteDuration(int numberOfRounds) {
        inDante = numberOfRounds;
    }

    public void giveMoney(int amount) {
        moneyAmount += amount;
    }

    public void setCardChanceStatus(boolean hasCardChance) {
        this.hasCardChance = hasCardChance;
    }

    public int getOnErasmus() {
        return onErasmus;
    }

    public void setOnErasmus(int onErasmus) {
        this.onErasmus = onErasmus;
    }

    public void setElectricDeficiencyStatus(boolean hasElectricDeficiency) {
        this.hasElectricDeficiency = hasElectricDeficiency;
    }

    public void setHowManyDicesToThrow(int howManyDicesToThrow) {
        this.dices = new ArrayList<>(howManyDicesToThrow);
        for (int i = 0; i < howManyDicesToThrow; i++) {
            dices.add(0);
        }
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public boolean isHasElectricDeficiency() {
        return hasElectricDeficiency;
    }

    public ArrayList<Integer> getDices() {
        return lastDices;
    }

    public int getDicesSum() {
        int output = 0;
        for (int dice : dices) {
            output += dice;
        }
        return output;
    }

    public void setNumberOfDoublets(int numberOfDoublets) {
        this.numberOfDoublets = numberOfDoublets;
    }

    public boolean canSellOrDegradeSomething() {
        for (Square square : Game.getBoard().getSquares()) {
            if (square instanceof Property property && property.getOwner() == this) {
                if (property.canBeSell() || property.canBeDegraded()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canUpgradeSomething() {
        for (Square square : Game.getBoard().getSquares()) {
            if (square instanceof Property property && property.getOwner() == this) {
                if (property.canBeUpgraded()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int giveEverythingAndBankrupt() {
        int output = valueOfProperties(ownedProperties()) + getMoneyAmount();
        for (Square square : Game.getBoard().getSquares()) {
            if(square instanceof Property property && property.getOwner() == this){
                property.cleanProperty();
            }
        }
        moneyAmount = 0;
        isBankrupt = true;
        return output;
    }

    public boolean isDoubleLastMove() {
        return doubleLastMove;
    }
}
