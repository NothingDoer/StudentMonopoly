package gui;

import gameLogic.PawnColor;
import gameLogic.Property;
import javafx.scene.image.Image;

public class Chooser {
    public static Image choosePawn(PawnColor color) {
        return switch (color) {
            case red -> new Image("file:../../assets/PIONEK4.png");
            case blue -> new Image("file:../../assets/PIONEK1.png");
            case green -> new Image("file:../../assets/PIONEK3.png");
            case yellow -> new Image("file:../../assets/PIONEK2.png");
        };
    }

    public static Image chooseDice(Integer integer) {
        return new Image("file:../../assets/Kostka" + integer + ".png");
    }

    public static String chooseStyle(PawnColor color) {
        return switch (color) {
            case red -> "saldo_red";
            case blue -> "saldo_blue";
            case green -> "saldo_green";
            case yellow -> "saldo_yellow";
        };
    }

    public static Image chooseImage(PawnColor color) {
        return switch (color) {
            case red -> new Image("file:../../assets/SALDOCZERWONY.png");
            case blue -> new Image("file:../../assets/SALDONIEBIESKI.png");
            case green -> new Image("file:../../assets/SALDOZIELONY.png");
            case yellow -> new Image("file:../../assets/SALDOZOLTY.png");
        };
    }

    public static Image choosePropertyIcon(Property property) {
        String file = "file:../../assets/Property";
        switch (property.getOwner().getPawn().getColor()) {
            case red -> file += "Red";
            case blue -> file += "Blue";
            case green -> file += "Green";
            case yellow -> file += "Yellow";
        }
        file += property.getUpgrades() + ".png";
        return new Image(file);
    }
}
