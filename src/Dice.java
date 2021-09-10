import java.util.ArrayList;
import java.util.Random;
/**
 * @author Arman Hatami
 * @version 1.0
 * dice class which gives us random dices
 */
public class Dice {
    /**
     * return dices using random numbers
     * @param diceCounter
     * @return dices
     */
    public ArrayList<String> getDice(int diceCounter){
        Random rnd = new Random();
        int random;
        ArrayList<String> dices = new ArrayList<>();
        for(int i = 0;i < diceCounter;i++) {
            random = Math.abs(rnd.nextInt() % 6) + 1;
            dices.add(String.valueOf(random));
            if (i == 0)
                System.out.print("first dice " + random + " ");
            else if (i == 1)
                System.out.print("second dice " + random + " ");
            else if (i == 2)
                System.out.print("third dice " + random + " ");
            else
                System.out.print((i + 1) + "th dice " + random + " ");
        }
        return dices;
    }
}
