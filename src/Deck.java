import java.util.ArrayList;
import java.util.Random;
/**
 * @author Arman Hatami
 * @version 1.0
 * deck class which stores all of cards and used cards
 */
public class Deck {
    private final int cardCounter = 40 ;
    private final int oneCounter = 6;
    private final int twoCounter = 19;
    private final int threeCounter = 29;
    private final int fourCounter = 35;
    private final int fiveCounter = 40;
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
                card.setCard(Card.Type.ORDER1);
                cards.add(card);
            }
            else
                if(i >= oneCounter && i < twoCounter){
                    Card card = new Card();
                    card.setCard(Card.Type.ORDER2);
                    cards.add(card);
                }
                else
                    if(i >= twoCounter && i < threeCounter){
                        Card card = new Card();
                        card.setCard(Card.Type.ORDER3);
                        cards.add(card);
                    }
                    else
                        if(i >= fourCounter && i < fiveCounter){
                            Card card = new Card();
                            card.setCard(Card.Type.ORDER4);
                            cards.add(card);
                        }
                        else
                        {
                            Card card = new Card();
                            card.setCard(Card.Type.ORDER5);
                            cards.add(card);
                        }
        }
    }
    public Card getCard(){
        Random random = new Random();
        cardsCounter();
        Card temp = cards.get(Math.abs(random.nextInt() % cards.size()));
        cards.remove(temp);
        return temp;
    }

    /**
     * shuffle cards and use them again
     */
    public void reuseCard(){
       cards.addAll(usedCards);
       usedCards.clear();
    }
    public void cardsCounter(){
        if(cards.size() == 0)
            reuseCard();
    }

    public ArrayList<Card> getUsedCards() {
        return usedCards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
