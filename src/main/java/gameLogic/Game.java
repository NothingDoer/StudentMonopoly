package gameLogic;

import connection.client.Client;
import connection.server.Server;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {

    private static Board board;
    private static int maxPlayers;
    private static int activePlayerIndex;
    private static int myPlayerIndex;
    private static ArrayList<Player> players;
    private static Server server;
    private static Client client;
    private static boolean started = false;
    private static GameType gameType;

    public static void init(String serverIP) throws IOException {
        client = new Client(serverIP, 8888);
        Game.gameType = GameType.MultiplayerClient;
    }

    public static void init(GameType gameType, int howManyPlayers) throws IOException {
        initHelper(howManyPlayers);
        if (gameType == GameType.MultiplayerClient) {
            throw new IllegalArgumentException();
        } else if (gameType == GameType.MultiplayerHost) {
            server = new Server();
        }
        Game.gameType = gameType;
    }

    private static void initHelper(int howManyPlayers) {
        maxPlayers = howManyPlayers;
        players = new ArrayList<>();
        activePlayerIndex = 0;
        board = new Board();
        started = false;
    }

    public static void addPlayer(Player player) {
        if (players.size() < maxPlayers) {
            players.add(player);
        }
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static int getNumberOfPlayers() {
        return players.size();
    }

    public static void conditionalNextRound() {
        if (getActivePlayer().isDoubleLastMove() && !getActivePlayer().isBankrupt()) {
            if(gameType == GameType.Singleplayer || getActivePlayerIndex() == myPlayerIndex) {
                getActivePlayer().makeDecision(DecisionType.RoundStart);
            }
            return;
        }
        do {
            activePlayerIndex++;
            if (activePlayerIndex >= players.size()) {
                activePlayerIndex = 0;
            }
        } while (getActivePlayer().isBankrupt());
        getActivePlayer().setNumberOfDoublets(0);
        getActivePlayer().setElectricDeficiencyStatus(false);
        getActivePlayer().setOnErasmus(getActivePlayer().getOnErasmus() - 1);
        if(getActivePlayer().getOnErasmus() < 0){
            getActivePlayer().setOnErasmus(0);
        }
        if(gameType == GameType.Singleplayer || getActivePlayerIndex() == myPlayerIndex){
            getActivePlayer().makeDecision(DecisionType.RoundStart);
        }
    }

    public static void conditionalEndRound() {
        if (getActivePlayer().isDoubleLastMove()) {
            getActivePlayer().makeDecision(DecisionType.RoundStart);
            return;
        }
        getActivePlayer().makeDecision(DecisionType.EndRound);
    }

    public static void closeGame() {
        if (server != null) {
            server.close();
        }
        if (client != null) {
            client.close();
        }
    }

    public static Board getBoard() {
        return board;
    }

    public static void pay(Player from, Player to, int amount) {
        from.takeMoney(amount);
        if (to != null) {
            to.giveMoney(amount);
        }
    }

    public static Player getPlayer(int playerIndex) {
        return players.get(playerIndex);
    }

    public static int getMaxPlayers() {
        return maxPlayers;
    }

    public static Player getActivePlayer() {
        return players.get(activePlayerIndex);
    }

    public static int getActivePlayerIndex() {
        return activePlayerIndex;
    }

    public static Server getServer() {
        return server;
    }

    public static Client getClient() {
        return client;
    }

    public static void setBoard(Board board) {
        Game.board = board;
    }

    public static void setMaxPlayers(int maxPlayers) {
        Game.maxPlayers = maxPlayers;
    }

    public static void setActivePlayerIndex(int activePlayerIndex) {
        Game.activePlayerIndex = activePlayerIndex;
    }

    public static void setPlayers(ArrayList<Player> players) {
        Game.players = players;
    }

    public static ArrayList<PawnColor> availableColors() {
        ArrayList<PawnColor> output = new ArrayList<>();
        output.add(PawnColor.yellow);
        output.add(PawnColor.red);
        output.add(PawnColor.green);
        output.add(PawnColor.blue);
        for (Player player : players) {
            output.remove(player.getPawn().getColor());
        }
        return output;
    }

    public static void activePlayerBuyProperty() {
        if (board.getSquares().get(getActivePlayer().getPawn().getPosition()) instanceof Property property) {
            property.buy(getActivePlayer());
        }
    }

    public static void evaluateActivePlayerPosition() {
        Player player = getActivePlayer();
        board.getSquares().get(player.getPawn().getPosition()).standOn(player);
    }

    public static boolean isStarted() {
        return started;
    }

    public static void start() {
        Game.started = true;
    }

    public static GameType getGameType() {
        return gameType;
    }

    public static void conditionalActivePlayerBuyOrUpgrade(Property property) {
        Player player = getActivePlayer();
        if (property.getOwner() == player && property.canBeUpgraded() && player.getMoneyAmount() >= property.getUpgradePrice()) {
            player.takeMoney(property.upgrade());
        }
    }

    public static void conditionalActivePlayerSellOrDegrade(Property property) {
        Player player = getActivePlayer();
        if (property.getOwner() == player) {
            if (property.canBeDegraded()) {
                player.giveMoney(property.degrade());
            } else if ((property.canBeSell())) {
                player.giveMoney(property.sellProperty());
            }
        }
    }

    public static void activePlayerDrawCard() {
        Square square = board.getSquares().get(getActivePlayer().getPawn().getPosition());

        if(square.getType() == TypesOfSqueres.CHANCE) {
            board.setDrawnCard(board.getChance().drawCard());
        }
        else if(square.getType() == TypesOfSqueres.STUDENT_CASH) {
            board.setDrawnCard(board.getStudentCash().drawCard());
        }
    }

    public static Player checkWinner(){
        Player output = null;
        for (Player player : players) {
            if(!player.isBankrupt()){
                if(output != null){
                    return null;
                }
                output = player;
            }
        }
        return output;
    }

    public static int getMyPlayerIndex() {
        return myPlayerIndex;
    }

    public static void setMyPlayerIndex(int myPlayer) {
        Game.myPlayerIndex = myPlayer;
    }

    public static void setStarted(boolean started) {
        Game.started = started;
    }
}

