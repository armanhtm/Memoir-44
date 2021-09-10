import java.util.ArrayList;
import java.util.HashSet;
/**
 * @author Arman Hatami
 * @version 1.0
 * team class which stores team name , used cards , current cards and troops of player
 */
public class Team {
    Input input = new Input();
    Error error = new Error();
    private teamName name;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Troop> troops = new ArrayList<>();
    private ArrayList<Troop> troopsInsertion = new ArrayList<>();
    public Team(teamName name,Deck deck){
        this.name = name;
        setTroops();
        setCards(deck);
    }
    public enum teamName{
        AXIS,
        ALLIED
    }
    public teamName getName() {
        return name;
    }
    public ArrayList<Troop> getTroops() {
        return troops;
    }

    /**
     * add troops of each team
     */
    public void setTroops() {
       if(name == teamName.ALLIED){
           for(int i = 0;i < 3; i++) {
               TankAllied temp = new TankAllied();
               troops.add(temp);
               troopsInsertion.add(temp);
           }
           for(int i = 0;i < 9; i++) {
               Infantry temp = new Infantry();
               troops.add(temp);
               troopsInsertion.add(temp);
           }
           for(int i = 0;i < 2; i++) {
               Cannon temp = new Cannon();
               troops.add(temp);
               troopsInsertion.add(temp);
           }
       }
       else {
           for(int i = 0;i < 6; i++) {
               TankAxis temp = new TankAxis();
               troops.add(temp);
               troopsInsertion.add(temp);
           }
           for(int i = 0;i < 7; i++) {
               Infantry temp = new Infantry();
               troops.add(temp);
               troopsInsertion.add(temp);
           }
       }
    }

    /**
     * add each team card
     * @param deck
     */
    public void setCards(Deck deck){
        if(name == teamName.ALLIED)
            for(int i = 0; i < 4 ; i++)
                cards.add(deck.getCard());
        else
            for(int i = 0;i < 2; i++)
                cards.add(deck.getCard());
    }
    public void printTroops(){
        for(int i = 0 ;i < troopsInsertion.size(); i++)
            System.out.println((i + 1) + "." + troopsInsertion.get(i).toString());
    }

    public ArrayList<Troop> getTroopsInsertion() {
        return troopsInsertion;
    }
    public void printCards(){
        for(int i = 0 ; i < cards.size();i++)
            System.out.println((i + 1) + "." + cards.get(i).CardToString());
    }

    /**
     * choose a card between player cards
     * @param deck
     * @return number of troops you can use
     */
    public int getCardType(Deck deck){
        int card = input.getInteger();
        int result =0;
        while(card > cards.size()){
            error.cardError();
            card = input.getInteger();
        }
        switch (cards.get(card - 1).CardToString()){
            case "order 1 unit":
                 result = 1;
                 break;
            case "order 2 units":
                result = 2;
                break;
            case "order 3 units":
                result = 3;
                break;
            case "order 4 units":
                result = 4;
                break;
            case "order 3 units from 1 type":
                result = 5;
                break;
        }
        deck.getUsedCards().add(cards.get(card - 1));
        cards.remove(card - 1);
        cards.add(deck.getCard());
        return result;
    }
    public void addToSelect(Troop troop){
        troopsInsertion.add(troop);
    }

    /**
     * return each team nickname
     * @return string
     */
    public String getBriefName(){
        if(name == teamName.ALLIED)
            return "AL";
        else
            return "AX";
    }

    /**
     * print alive troops of each team
     */
    public void troops(){
        for(int i = 0 ;i < troops.size(); i++)
            System.out.println((i + 1) + "." + troops.get(i).TroopToString());
    }
}
