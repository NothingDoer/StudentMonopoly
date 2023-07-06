package connection.server;

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

public class ClientHandler extends Thread {
    private final Socket clientSocket;
    ObjectOutputStream objectOutput;
    private final ObjectInputStream objectInput;
    private boolean working;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        objectOutput = new ObjectOutputStream(clientSocket.getOutputStream());
        objectInput = new ObjectInputStream(clientSocket.getInputStream());
        working = true;
        System.out.println("ClientHandler na sokecie o numerze portu: " + clientSocket.getPort() + " rozpoczoł działanie.");
    }

    @Override
    public void run() {
        try {
            sendGameInfo();
            while (working) {
                updateGameInfo();
                Game.getServer().forwardInfoUpdate(this);
            }
        } catch (IOException e) {
            if (working) {
                System.out.println("Bład podczas odbierania danych od klienta. Klient zostanie rozłączony!");
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    System.out.println("Bład podczas zamykania gniazda!");
                }
            }
        }
        System.out.println("ClientHandler na sokecie o numerze portu: " + clientSocket.getPort() + " zakończył działanie.");
    }

    private void updateGameInfo() throws IOException {
        try {
            Game.setMaxPlayers(objectInput.readInt());
            Game.setActivePlayerIndex(objectInput.readInt());
            Game.setBoard((Board) objectInput.readObject());
            Game.setPlayers((ArrayList<Player>) objectInput.readObject());
            Game.getBoard().setDrawnCard((Card) objectInput.readObject());
            Game.setStarted(objectInput.readBoolean());

            Platform.runLater(() -> {
                if (Game.isStarted()) {
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

    public void close() {
        working = false;
        try {
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Bład podczas zamykania gniazda!");
        }
        this.interrupt();
    }
}
