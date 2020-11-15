import java.util.ArrayList;
import java.util.Arrays;

abstract class Troop {
     Dice dice;
     Input input;
     Error error;
     boolean canAttack;
     boolean canmove;
     Coordinate coordinate;
     Point currentPoint;
     Point previousPoint;
     String[] validMoves = new String[]{"R", "L", "UR", "UL", "DL", "DR"};
    abstract void Move(String movement);
    public int moveCounter(String[] movements){
        int sum = 0, i = 0;
        for(String str : movements) {
            sum += str.charAt(i);
            i++;
        }
        return sum;
    }
    public void moveSteps(String[] movements){
        for(String str : movements){
            switch (str.charAt(1)){
                case 'U':
                    if(str.charAt(2) == 'R')
                        coordinate.upRight();
                    else
                        if(str.charAt(2) == 'L')
                            coordinate.upLeft();
                    break;
                case 'D':
                    if(str.charAt(2) == 'R')
                        coordinate.downRight();
                    else
                    if(str.charAt(2) == 'L')
                        coordinate.downLeft();
                    break;
                case 'L':
                    coordinate.Left();
                    break;
                case 'R':
                    coordinate.Right();
                    break;
            }
        }
    }
    public boolean isValid(String[] movements){
        for(String str : movements)
            if(!Arrays.asList(validMoves).contains(str.charAt(1)) &&
                    !Arrays.asList(validMoves).contains(str.charAt(1) + str.charAt(2)))
                return false;
         return true;
    }

    public boolean isCanAttack() {
        return canAttack;
    }
    abstract void attack(Point point);

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public Point getPreviousPoint() {
        return previousPoint;
    }
}
