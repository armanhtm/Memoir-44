import java.util.ArrayList;
/**
 * @author Arman Hatami
 * @version 1.0
 * Infantry troop
 */
public class Infantry extends Troop{
    private int unitPerTeam = 4;
    private final int validMove = 2;
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
        if(moveCounter(movements) == 2)
            canAttack = false;
        else
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
        distance.setDiceCounter(4 - pointsBetween);
        if(!canAttack){
            error.attackError();
            return false;
        }

        switch (point.getType()) {
            case HILL:
            case JUNGLE:
                distance.decrement(1);
                break;
            case SHELTER:
                if (point.getTroop().getTeam().getName() == Team.teamName.AXIS)
                   distance.decrement(1);
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
                if (point.getTroop() instanceof TankAllied || point.getTroop() instanceof TankAxis) {
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
    public void die(){
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
        return "Infantry" + "(" + this.coordinate.getX() +"," + this.coordinate.getY() + ")";
    }
    /**
     * just return the name of troop
     * @return string
     */
    public String toString(){
        return "Infantry";
    }
}
