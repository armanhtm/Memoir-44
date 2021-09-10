import java.util.ArrayList;
/**
 * @author Arman Hatami
 * @version 1.0
 * Allied tank troop
 */
public class TankAllied extends Troop{
    private int unitPerTeam = 3;
    private final int validMove = 4;
    /**
     * move method to change location through the board
     * @param movement
     * @param board
     */
    void Move(String movement,Board board) {
        board.getPoint(coordinate.getX(),coordinate.getY()).setTroop(null);
        String[] movements = movement.split("\\s");
        while (moveCounter(movements) > validMove) {
            error.moveError();
            movement = input.getInput();
            movements = movement.split("\\s");
        }
        canAttack = true;
        moveSteps(movements,board);
        board.getPoint(coordinate.getX(),coordinate.getY()).setTroop(this);
        currentPoint = board.getPoint(coordinate.getX(),coordinate.getY());
    }

    /**
     * attack method to hit the targets
     * @param point
     * @return boolean(true when target is destroyed)
     */
    boolean attack(Point point) {
        int pointsBetween = distance.CalculateDistance(this.currentPoint,point);
        if(pointsBetween > 3) {
            error.farError();
            return false;
        }
        distance.setDiceCounter(3);
        if(!canAttack){
            error.attackError();
            return false;
        }
        else{
            switch (point.getType()) {
                case HILL:
                    distance.decrement(1);
                    break;
                case JUNGLE:
                    distance.decrement(2);
                    break;
                case SHELTER:
                    if (point.getTroop().getTeam().getName() == Team.teamName.AXIS)
                        distance.decrement(2);
            }
        }
        ArrayList<String> result = distance.diceResult();
        if(result.contains("5")) {
            point.getTroop().kill();
            if (point.getTroop().livesCounter() == 0)
                return true;
        }
        else {
            if (result.contains("1") || result.contains("6")) {
                if (point.getTroop() instanceof Infantry) {
                    point.getTroop().kill();
                    if (point.getTroop().livesCounter() == 0)
                        return true;
                }
            } else if (result.contains("2")) {
                if (point.getTroop() instanceof TankAllied) {
                    point.getTroop().kill();
                    if (point.getTroop().livesCounter() == 0)
                        return true;
                }
            }
            else
                error.badLuck();
        }
        return false;
    }
    /**
     * set alive equals to false after troop is destroyed
     */
    public void die() {
        alive = false;
        this.team.getTroops().remove(this);
    }

    /**
     * decrease the blood of troop when it is hit
     */
    public void kill() {
        unitPerTeam --;
        if(unitPerTeam == 0)
            die();
    }
    int livesCounter() {
        return unitPerTeam;
    }
    /**
     * return info of troop as a string
     * @return string of info
     */
    public String TroopToString(){
        return "Tank" + "(" + this.coordinate.getX() + "," + this.coordinate.getY() + ")";
    }
    /**
     * just return the name of troop
     * @return string
     */
    public String toString(){
        return "Tank";
    }
}
