public class Dice {
    public StringBuilder getDice(int diceCounter){
        double random;
        StringBuilder dices = new StringBuilder();
        for(int i = 0;i < diceCounter;i++) {
            random = (Math.random() % 6) + 1;
            dices.append(random);
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
