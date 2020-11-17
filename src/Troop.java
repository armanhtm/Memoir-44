import java.util.ArrayList;
import java.util.Arrays;

abstract class Troop {
     Team team;
     Input input;
     Error error;
     boolean canAttack;
     boolean alive = true;
     Coordinate coordinate;
     Point currentPoint;
     Distance distance;
     String[] validMoves = new String[]{"R", "L", "UR", "UL", "DL", "DR"};
     boolean flag;
    abstract void Move(String movement);
    public int moveCounter(String[] movements){
        int sum = 0, i = 0;
        for(String str : movements) {
            sum += str.charAt(i);
            i++;
        }
        return sum;
    }
    public void moveSteps(String[] movements,Board board){
        canAttack = true;
        flag = true;
        boolean flagTroop = false;
        if(currentPoint.getTroop() instanceof Cannon
                || currentPoint.getTroop() instanceof TankAllied
                || currentPoint.getTroop() instanceof TankAxis)
            flagTroop = true;
        for(String str : movements){
            if(!flag) {
                error.stuck();
                break;
            }
            switch (str.charAt(1)){
                case 'U':
                    if(str.charAt(2) == 'R'){
                        coordinate.upRight();
                        if(board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.RIVER)
                            coordinate.downLeft();
                        else
                            if(board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.SHELTER && flagTroop)
                                coordinate.downLeft();
                    }
                    else
                        if(str.charAt(2) == 'L') {
                            coordinate.upLeft();
                            if (board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.RIVER)
                                coordinate.downRight();
                            else
                            if(board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.SHELTER && flagTroop)
                                coordinate.downRight();
                        }
                    break;
                case 'D':
                    if(str.charAt(2) == 'R') {
                        coordinate.downRight();
                        if (board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.RIVER)
                            coordinate.upLeft();
                        else
                        if(board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.SHELTER && flagTroop)
                            coordinate.upLeft();
                    }
                    else
                    if(str.charAt(2) == 'L') {
                        coordinate.downLeft();
                        if (board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.RIVER)
                            coordinate.upRight();
                        else
                        if(board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.SHELTER && flagTroop)
                            coordinate.upRight();
                    }
                    break;
                case 'L':
                    coordinate.Left();
                    if (board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.RIVER)
                        coordinate.Right();
                    else
                    if(board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.SHELTER && flagTroop)
                        coordinate.Right();
                    break;
                case 'R':
                    coordinate.Right();
                    if (board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.RIVER)
                        coordinate.Left();
                    else
                    if(board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.SHELTER && flagTroop)
                        coordinate.Left();
                    break;
            }
            if(board.getPoints()[coordinate.getX()][coordinate.getY()].getType() == Point.Type.JUNGLE) {
                flag = false;
                canAttack = false;
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
    abstract public void die();
    abstract public void kill();

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
