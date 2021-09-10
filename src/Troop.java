import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Arman Hatami
 * @version 1.0
 * class of troop which is abstract and we will save common adjectives and methods of different troop here
 */

abstract class Troop {
     Team team;
     Input input = new Input();
     Error error = new Error();
     boolean canAttack = true;
     boolean alive = true;
     Coordinate coordinate = new Coordinate();
     Point currentPoint;
     Distance distance = new Distance();
     String[] validMoves = new String[]{"R", "L", "UR", "UL", "DL", "DR"};
     boolean flag;
    abstract void Move(String movement,Board board);

    /**
     * counts the number moves
     * @param movements
     * @return
     */
    public int moveCounter(String[] movements){
        int sum = 0;
        for(String str : movements)
            sum += Integer.parseInt(String.valueOf(str.charAt(0)));
        return sum;
    }

    /**
     * do the movements step by step
     * @param movements
     * @param board
     */
    public void moveSteps(String[] movements,Board board){
        canAttack = true;
        flag = true;
        boolean flagTroop = false;
        if(this instanceof Cannon || this instanceof TankAllied || this instanceof TankAxis)
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
    public boolean isCanAttack() {
        return canAttack;
    }
    abstract boolean attack(Point point);

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
    abstract int livesCounter();
    abstract String TroopToString();

    public void setCoordinate(int x, int y){
        this.coordinate.setX(x);
        this.coordinate.setY(y);
    }

    public void setCurrentPoint(Point currentPoint) {
        this.currentPoint = currentPoint;
    }
}
