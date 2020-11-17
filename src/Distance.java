import java.util.ArrayList;

public class Distance {
    private Dice dice;
    private int diceCounter;

    public void setDiceCounter(int diceCounter) {
        this.diceCounter = diceCounter;
    }

    public int getDiceCounter() {
        return diceCounter;
    }
    public void decrement(int count){
        diceCounter -= count;
    }
    public int CalculateDistance(Point pointA,Point pointB){
        if(pointA.getX() == pointB.getX())
            return (pointA.getY() - pointB.getY()) / 2;
        if(pointA.getY() == pointB.getY())
            return (pointA.getX() - pointB.getX()) / 2;
        int temp;
        int xDistance = Math.abs(pointB.getX() - pointA.getX());

        if(pointA.getY() < pointB.getY())
            temp = pointA.getY() + xDistance;
        else
            temp = pointA.getY() + xDistance;

        int yDistance = Math.abs(pointB.getY() - temp) / 2;
        int totalDistance = yDistance + xDistance;
        return totalDistance;
    }

   public ArrayList<String> diceResult(){
        return dice.getDice(diceCounter);
   }
}
