package gameLogic;

import java.io.Serializable;

public class Pawn implements Serializable {
    private int position = 0;

    private final PawnColor color;

    Pawn(PawnColor color) {
        this.color = color;
    }

    public int getPosition() {
        return position;
    }

    public void move(int shift) {
        position += shift;
        if (position >= GameInfo.NUMBER_OF_SQUARES) {
            position = position % GameInfo.NUMBER_OF_SQUARES;
            return;
        }
        if (position < 0)
            position += GameInfo.NUMBER_OF_SQUARES;
    }

    public void getToSquare(int squareIndex) {
        position = squareIndex;
    }

    public PawnColor getColor() {
        return color;
    }
}
