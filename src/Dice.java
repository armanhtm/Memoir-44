import java.util.ArrayList;

public class Dice {
    public ArrayList<String> getDice(int diceCounter){
        double random;
        ArrayList<String> dices = new ArrayList<>();
        for(int i = 0;i < diceCounter;i++) {
            random = (Math.random() % 6) + 1;
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
