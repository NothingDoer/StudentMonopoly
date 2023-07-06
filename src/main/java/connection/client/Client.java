package connection.client;

import gameLogic.Board;
import gameLogic.DecisionType;
import gameLogic.Game;
import gameLogic.Player;
import gameLogic.cards.Card;
import gui.*;
import javafx.application.Platform;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client extends Thread {
    private final Socket socket;
    private final ObjectOutputStream objectOutput;
    private final ObjectInputStream objectInput;
    private boolean working;

    public Client(String serverIP, int port) throws IOException {
        socket = new Socket(serverIP, port);
        objectOutput = new ObjectOutputStream(socket.getOutputStream());
        objectInput = new ObjectInputStream(socket.getInputStream());
        working = true;
        this.start();
        System.out.println("Połączono z serwerem.");
    }

    @Override
    public void run() {
        try {
            getGameInfo();
            while (working) {
                updateGameInfo();
            }
        } catch (IOException e) {
            if (working) {
                System.out.println("Bład podczas odbierania danych od serwera. Zostałeś rozłączony!");
                try {
                    socket.close();
                } catch (IOException ex) {
                    System.out.println("Bład podczas zamykania gniazda!");
                }
            }
        }
        System.out.println("Rozłączono z serwerem!");
    }

    public void close() {
        working = false;
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Bład podczas zamykania gniazda!");
        }
        this.interrupt();
    }

    private void getGameInfo() throws IOException {
        try{
            Game.setMaxPlayers(objectInput.readInt());
            Game.setActivePlayerIndex(objectInput.readInt());
            Game.setBoard((Board)objectInput.readObject());
            Game.setPlayers((ArrayList<Player>)objectInput.readObject());
            Game.getBoard().setDrawnCard((Card) objectInput.readObject());
            Game.setStarted(objectInput.readBoolean());
            Platform.runLater(() -> {
                MenuShower.showNickAndPawnMenu();
                System.out.println("Polaczono");
            });
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateGameInfo() throws IOException {
        try{
            Game.setMaxPlayers(objectInput.readInt());
            Game.setActivePlayerIndex(objectInput.readInt());
            Game.setBoard((Board)objectInput.readObject());
            Game.setPlayers((ArrayList<Player>)objectInput.readObject());
            Game.getBoard().setDrawnCard((Card) objectInput.readObject());
            Game.setStarted(objectInput.readBoolean());

            Platform.runLater(() -> {
                if(Game.isStarted()){
                    ActivePlayerInfoShower.showActivePlayerInfo();
                    if(Game.getActivePlayer().getDices() != null){
                        DicesShower.showDices(Game.getActivePlayer().getDices());
                    }
                    PawnsShower.showPawns();
                    if(Game.getActivePlayerIndex() == Game.getMyPlayerIndex()){
                        Game.getActivePlayer().makeDecision(DecisionType.RoundStart);
                    }
                    if(Game.checkWinner() != null){
                        DecisionButtonsShower.showWinDecisionButtons();
                    }
                    if(Game.getBoard().getDrawnCard() != null){
                        CardShower.showCard();
                    }
                    else{
                        CardShower.removeCard();
                    }
                }
                PlayersInfoShower.showPlayersInfo();
                PropertyIconsShower.showPropertyIcons();
            });
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendGameInfo() throws IOException {
        objectOutput.writeInt(Game.getMaxPlayers());
        objectOutput.writeInt(Game.getActivePlayerIndex());
        objectOutput.writeObject(Game.getBoard());
        objectOutput.writeObject(Game.getPlayers());
        objectOutput.writeObject(Game.getBoard().getDrawnCard());
        objectOutput.writeBoolean(Game.isStarted());
        objectOutput.reset();
    }
}
