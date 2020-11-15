import java.awt.*;
import java.util.Scanner;

public class Card {
    private Input input;
    private Error error;
    Type card;
    private enum Type{
        ORDER1,
        ORDER2,
        ORDER3,
        ORDER4,
        ORDER5
    }
    public int getCardType(){
        String card = input.getInput();
        while(!contains(card)){
            error.cardError();
            card = input.getInput();
        }
        switch (Type.valueOf(card)){
            case ORDER1:
                return 1;
            case ORDER2:
                return 2;
            case ORDER3:
                return 3;
            case ORDER4:
                return 4;
            case ORDER5:
                return 5;
        }
        return 0;
    }
    public boolean contains(String test) {
        for (Type type : Type.values())
            if (type.name().equals(test))
                return true;
        return false;
    }

    public void setCard(String cardName) {
        this.card = Type.valueOf(cardName);
    }
}
