import java.util.ArrayList;
import java.util.HashSet;

public class Team {
    Input input;
    Error error;
    private teamName name;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Troop> troops = new ArrayList<>();
    private ArrayList<Troop> troopsInsertion = new ArrayList<>();
    private HashSet<Troop> selectedTroops = new HashSet<>();
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

    public void setTroops() {
       if(name == teamName.ALLIED){
           for(int i = 0;i < 3; i++) {
               troops.add(new TankAllied());
               troopsInsertion.add(new TankAllied());
           }
           for(int i = 0;i < 8; i++) {
               troops.add(new Infantry());
               troopsInsertion.add(new Infantry());
           }
           for(int i = 0;i < 2; i++) {
               troops.add(new Cannon());
               troopsInsertion.add(new Cannon());
           }
       }
       else {
           for(int i = 0;i < 6; i++) {
               troops.add(new TankAxis());
               troopsInsertion.add(new TankAxis());
           }
           for(int i = 0;i < 7; i++) {
               troops.add(new Infantry());
               troopsInsertion.add(new Infantry());
           }
       }
    }
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
            System.out.println((i + 1) + "." + troopsInsertion.get(i).TroopToString());
    }

    public ArrayList<Troop> getTroopsInsertion() {
        return troopsInsertion;
    }
    public void printCards(){
        for(int i = 0 ; i < cards.size();i++)
            System.out.println((i + 1) + cards.get(i).CardToString());
    }
    public int getCardType(){
        String card = input.getInput();
        while(!contains(card)){
            error.cardError();
            card = input.getInput();
        }
        switch (Card.Type.valueOf(card)){
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
        for (Card.Type type : Card.Type.values())
            if (type.name().equals(test))
                return true;
        return false;
    }
    public void addToSelect(Troop troop){
        selectedTroops.add(troop);
    }
}
