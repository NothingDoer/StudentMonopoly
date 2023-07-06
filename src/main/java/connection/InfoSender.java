package connection;

import gameLogic.Game;

import java.io.IOException;

public class InfoSender {
    public static void sendInfo() {
        try {
            if (Game.getServer() != null) {
                Game.getServer().sendGameInfo();
            } else if (Game.getClient() != null) {
                Game.getClient().sendGameInfo();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
