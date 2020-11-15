import java.util.ArrayList;

public class Deck {
    private final int cardCounter = 40 ;
    private final int oneCounter = 6;
    private final int twoCounter = 13;
    private final int threeCounter = 10;
    private final int fourCounter = 6;
    private final int fiveCounter = 5;
    private ArrayList<Card> cards;
    public Deck(){
        cards = new ArrayList<>();
        setDeck(cards);
    }

    public void setDeck(ArrayList<Card> cards) {
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
        return cards.get((int)(Math.random()%40));
    }
    public void reuseCard(Card card){
       cards.add(card);
    }
}
