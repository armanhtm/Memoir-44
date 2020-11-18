import java.awt.*;
import java.util.Scanner;

public class Card {
    private Input input;
    private Error error;
    Type card;
    enum Type{
        ORDER1,
        ORDER2,
        ORDER3,
        ORDER4,
        ORDER5
    }
    public void setCard(String cardName) {
        this.card = Type.valueOf(cardName);
    }
    public String CardToString(){
        switch(card){
            case ORDER5:
                return "order 3 units from 1 type";
            case ORDER4:
                return "order 4 units";
            case ORDER3:
                return "order 3 units";
            case ORDER2:
                return "order 2 units";
            case ORDER1:
                return "order 1 unit";
        }
        return null;
    }
}
