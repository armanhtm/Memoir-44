import java.util.ArrayList;

public class Deck {
    private final int cardCounter = 40 ;
    private final int oneCounter = 6;
    private final int twoCounter = 13;
    private final int threeCounter = 10;
    private final int fourCounter = 6;
    private final int fiveCounter = 5;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> usedCards = new ArrayList<>();
    public Deck(){
        cards = new ArrayList<>();
        setDeck();
    }

    public void setDeck() {
        for(int i = 0;i < cardCounter; i++){
            if(i < oneCounter){
                Card card = new Card();
                card.setCard("ORDER1");
                cards.add(card);
            }
            else
                if(i >= oneCounter && i < twoCounter){
                    Card card = new Card();
                    card.setCard("ORDER2");
                    cards.add(card);
                }
                else
                    if(i >= twoCounter && i < threeCounter){
                        Card card = new Card();
                        card.setCard("ORDER3");
                        cards.add(card);
                    }
                    else
                        if(i >= fourCounter && i < fiveCounter){
                            Card card = new Card();
                            card.setCard("ORDER4");
                            cards.add(card);
                        }
                        else
                        {
                            Card card = new Card();
                            card.setCard("ORDER5");
                            cards.add(card);
                        }
        }
    }
    public Card getCard(){
        Card temp = cards.get((int)(Math.random()%cards.size()));
        cards.remove(temp);
        usedCards.add(temp);
        return temp;
    }
    public void reuseCard(){
       cards.addAll(usedCards);
    }
    public void cardsCounter(){
        if(cards.size() == 0)
            reuseCard();
    }
}
