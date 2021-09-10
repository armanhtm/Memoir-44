import java.awt.*;
import java.util.Scanner;
/**
 * @author Arman Hatami
 * @version 1.0
 * card class which can store type of cards
 */
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
    public void setCard(Type cardName) {
        this.card = cardName;
    }
    /**
     * convert cards name to readable strings
     */
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
